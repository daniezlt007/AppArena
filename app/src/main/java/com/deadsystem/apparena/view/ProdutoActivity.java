package com.deadsystem.apparena.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.adapter.ClienteAdapter;
import com.deadsystem.apparena.adapter.ProdutoAdapter;
import com.deadsystem.apparena.dao.ClienteDAO;
import com.deadsystem.apparena.dao.ProdutoDAO;
import com.deadsystem.apparena.helper.RecyclerItemClickListener;
import com.deadsystem.apparena.model.Cliente;
import com.deadsystem.apparena.model.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ProdutoActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private ProdutoAdapter adapter;
    private List<Produto> produtos;
    private Produto produtoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler);
        atualizaRecyclerView();
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        produtoSelecionado = produtos.get(position);
                        Intent intent = new Intent(ProdutoActivity.this, FormProdutoActivity.class);
                        intent.putExtra("produtoSelecionado", produtoSelecionado);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        produtoSelecionado = produtos.get(position);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(ProdutoActivity.this);
                        dialog.setTitle("Confirma Exclusão?");
                        dialog.setMessage("Deseja excluir o produto:\n" + produtoSelecionado.getDescricao() + " ?");
                        dialog.setPositiveButton("Sim", (dialogInterface, i) -> {
                            ProdutoDAO produtoDAO = new ProdutoDAO(ProdutoActivity.this);
                            if(produtoDAO.deletarProduto(produtoSelecionado)){
                                Toast.makeText(ProdutoActivity.this, "Produto excluído com sucesso.", Toast.LENGTH_LONG).show();
                                atualizaRecyclerView();
                            }else{
                                Toast.makeText(ProdutoActivity.this, "Erro ao excluir produto selecionado.", Toast.LENGTH_LONG).show();
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
                startActivity(new Intent(ProdutoActivity.this, FormProdutoActivity.class)));


    }

    private void atualizaRecyclerView() {
        ProdutoDAO dao = new ProdutoDAO(ProdutoActivity.this);
        produtos = dao.buscarTodosProdutos();
        recyclerView.setLayoutManager(new LinearLayoutManager(ProdutoActivity.this));
        adapter = new ProdutoAdapter(produtos);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaRecyclerView();
    }

}