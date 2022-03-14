package com.deadsystem.apparena.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.deadsystem.apparena.adapter.ClienteAdapter;
import com.deadsystem.apparena.dao.ClienteDAO;
import com.deadsystem.apparena.helper.RecyclerItemClickListener;
import com.deadsystem.apparena.model.Cliente;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.deadsystem.apparena.R;

import java.util.List;

public class ClienteActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private ClienteAdapter adapter;
    private List<Cliente> clientes;
    private Cliente clienteSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler);
        atualizaRecyclerView();
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        clienteSelecionado = clientes.get(position);
                        Intent intent = new Intent(ClienteActivity.this, FormClientActivity.class);
                        intent.putExtra("clienteSelecionado", clienteSelecionado);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        clienteSelecionado = clientes.get(position);

                        AlertDialog.Builder dialog = new AlertDialog.Builder(ClienteActivity.this);
                        dialog.setTitle("Confirma Exclusão?");
                        dialog.setMessage("Deseja excluir o cliente:\n" + clienteSelecionado.getNomeCliente() + " ?");

                        dialog.setPositiveButton("Sim", (dialogInterface, i) -> {
                            ClienteDAO clienteDAO = new ClienteDAO(ClienteActivity.this);
                            if(clienteDAO.deletarCliente(clienteSelecionado)){
                                Toast.makeText(ClienteActivity.this, "Cliente excluído com sucesso.", Toast.LENGTH_LONG).show();
                                atualizaRecyclerView();
                            }else{
                                Toast.makeText(ClienteActivity.this, "Erro ao excluir cliente selecionado.", Toast.LENGTH_LONG).show();
                            }
                        });

                        dialog.setNegativeButton("Não", null);
                        dialog.create();
                        dialog.show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));
        fab.setOnClickListener(view ->
                startActivity(new Intent(ClienteActivity.this, FormClientActivity.class)));
    }

    private void atualizaRecyclerView() {
        ClienteDAO dao = new ClienteDAO(ClienteActivity.this);
        clientes = dao.buscarTodosClientes();
        recyclerView.setLayoutManager(new LinearLayoutManager(ClienteActivity.this));
        adapter = new ClienteAdapter(clientes);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaRecyclerView();
    }

}