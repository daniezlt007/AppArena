package com.deadsystem.apparena.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.deadsystem.apparena.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonCliente, buttonProduto, buttonVenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        buttonCliente.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ClienteActivity.class);
            startActivity(intent);
        });

        buttonProduto.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
            startActivity(intent);
        });

        buttonVenda.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PedidoActivity.class);
            startActivity(intent);
        });

    }

    private void initComponents(){
        buttonCliente = findViewById(R.id.btn_clientes);
        buttonProduto = findViewById(R.id.btn_produtos);
        buttonVenda = findViewById(R.id.btn_vendas);
    }
}