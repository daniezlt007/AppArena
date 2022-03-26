package com.deadsystem.apparena.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.adapter.ClienteAdapter;
import com.deadsystem.apparena.adapter.ProdutoAdapter;
import com.deadsystem.apparena.dao.ProdutoDAO;
import com.deadsystem.apparena.entities.ClienteEntity;
import com.deadsystem.apparena.entities.ProdutoEntity;
import com.deadsystem.apparena.helper.RecyclerItemClickListener;
import com.deadsystem.apparena.holder.ClienteViewHolder;
import com.deadsystem.apparena.holder.ProdutoViewHolder;
import com.deadsystem.apparena.model.Produto;
import com.deadsystem.apparena.viewmodel.ClienteViewModel;
import com.deadsystem.apparena.viewmodel.ProdutoViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.List;

public class ProdutoActivity extends AppCompatActivity implements ProdutoViewHolder.HandleProdutoClick {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private ProdutoAdapter adapter;
    private ProdutoViewModel viewModel;
    private TextView textViewResultProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        fab = findViewById(R.id.fab);
        textViewResultProduct = findViewById(R.id.textViewResultProduct);


        recyclerView = findViewById(R.id.recycler);
        initViewModel();
        initRecycler();






      /*  recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
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
                        dialog.setTitle("Confirma Exclusão");
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
        ));*/

        fab.setOnClickListener(view ->
                startActivity(new Intent(ProdutoActivity.this, FormProdutoActivity.class)));


    }

    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(ProdutoActivity.this));
        adapter = new ProdutoAdapter(this, this);
        recyclerView.setAdapter(adapter);
    }

    private void initViewModel(){
        viewModel = new ViewModelProvider(this).get(ProdutoViewModel.class);
        viewModel.getListProdutoObserver().observe(this, new Observer<List<ProdutoEntity>>() {
            @Override
            public void onChanged(List<ProdutoEntity> produtos) {
                if(produtos == null){
                    textViewResultProduct.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }else{
                    adapter.setmProdutosList(produtos);
                    recyclerView.setVisibility(View.VISIBLE);
                    textViewResultProduct.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getAllProducts();
    }

    @Override
    public void itemClick(ProdutoEntity produtoEntity) {
        Intent intent = new Intent(ProdutoActivity.this, FormProdutoActivity.class);
        intent.putExtra("produtoSelecionado", produtoEntity);
        startActivity(intent);
    }

    @Override
    public void removeItem(ProdutoEntity produtoEntity) {

    }

    @Override
    public void editItem(ProdutoEntity produtoEntity) {

    }
}