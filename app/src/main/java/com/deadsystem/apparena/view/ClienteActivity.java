package com.deadsystem.apparena.view;

import android.content.Intent;
import android.os.Bundle;

import com.deadsystem.apparena.adapter.ClienteAdapter;
import com.deadsystem.apparena.entities.ClienteEntity;
import com.deadsystem.apparena.helper.RecyclerItemClickListener;
import com.deadsystem.apparena.holder.ClienteViewHolder;
import com.deadsystem.apparena.viewmodel.ClienteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.deadsystem.apparena.R;

import java.util.List;

public class ClienteActivity extends AppCompatActivity implements ClienteViewHolder.HandleClienteClick {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private TextView textViewResult;
    private ClienteAdapter adapter;
    private ClienteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler);
        textViewResult =  findViewById(R.id.textViewResult);

        initViewModel();
        initRecycler();
        viewModel.getAllClients();
        /*código recortado*/


        fab.setOnClickListener(view ->
                startActivity(new Intent(ClienteActivity.this, FormClientActivity.class)));



    }

    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(ClienteActivity.this));
        adapter = new ClienteAdapter(this, this);
        recyclerView.setAdapter(adapter);
    }

    private void initViewModel(){
        viewModel = new ViewModelProvider(this).get(ClienteViewModel.class);
        viewModel.getListClienteObserver().observe(this, new Observer<List<ClienteEntity>>() {
            @Override
            public void onChanged(List<ClienteEntity> clientes) {
                if(clientes == null){
                    textViewResult.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }else{
                    adapter.setmClientesList(clientes);
                    recyclerView.setVisibility(View.VISIBLE);
                    textViewResult.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void itemClick(ClienteEntity clienteEntity) {
        Intent intent = new Intent(ClienteActivity.this, FormClientActivity.class);
        intent.putExtra("clienteSelecionado", clienteEntity);
        startActivity(intent);
    }

    @Override
    public void removeItem(ClienteEntity clienteEntity) {
        this.viewModel.deleteClient(clienteEntity);
    }

    @Override
    public void editItem(ClienteEntity clienteEntity) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getAllClients();
    }
}
