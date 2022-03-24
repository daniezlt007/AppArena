package com.deadsystem.apparena.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.entities.ClienteEntity;
import com.deadsystem.apparena.model.Cliente;
import com.deadsystem.apparena.viewmodel.ClienteViewModel;

public class FormClientActivity extends AppCompatActivity {

    private ClienteViewModel clienteViewModel;
    private Button btnSalvarCliente;
    private TextView txtNomeCliente, txtCelularCliente, txtApelidoCliente, txtCpfCliente;
    private ClienteEntity clienteAtual;
    private Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_client);
        initViewModel();

        initComponents();

        clienteAtual = (ClienteEntity) getIntent().getSerializableExtra("clienteSelecionado");
        if (clienteAtual != null) {
            btnSalvarCliente.setText(R.string.btn_atualizar);
            id = clienteAtual.id;
            txtNomeCliente.setText(clienteAtual.nomeCliente);
            txtCelularCliente.setText(clienteAtual.telefoneCliente);
            txtCpfCliente.setText(clienteAtual.cpfcliente);
            txtApelidoCliente.setText(clienteAtual.apelidoCliente);
        }

        btnSalvarCliente.setOnClickListener(view1 -> {
            if (clienteAtual != null) {
                clienteAtual.id = id;
                clienteAtual.nomeCliente = txtNomeCliente.getText().toString().toUpperCase();
                clienteAtual.telefoneCliente = txtCelularCliente.getText().toString();
                clienteAtual.apelidoCliente = txtApelidoCliente.getText().toString();
                clienteAtual.cpfcliente = txtCpfCliente.getText().toString();
                clienteViewModel.updateClient(clienteAtual);
                Toast.makeText(FormClientActivity.this, "Atualizado com sucesso.", Toast.LENGTH_LONG).show();
                finish();
            } else {
                if (txtNomeCliente.getText().toString().isEmpty()) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(FormClientActivity.this);
                    dialog.setTitle("Erro");
                    dialog.setMessage("Cliente com o nome: \n" + clienteAtual.nomeCliente + " já está cadastrado");
                    dialog.setPositiveButton("Ok", null);
                    dialog.create();
                    dialog.show();
                    id = null;
                    clienteAtual = null;
                } else {
                    clienteAtual = new ClienteEntity();
                    clienteAtual.nomeCliente = txtNomeCliente.getText().toString().toUpperCase();;
                    clienteAtual.telefoneCliente = txtCelularCliente.getText().toString();
                    clienteAtual.apelidoCliente = txtApelidoCliente.getText().toString();
                    clienteAtual.cpfcliente = txtCpfCliente.getText().toString();

                    clienteViewModel.insertClient(clienteAtual);
                    Toast.makeText(FormClientActivity.this, "Salvo com sucesso.", Toast.LENGTH_LONG).show();
                    finish();
                }
            }

        });

    }

    private void initComponents() {
        btnSalvarCliente = findViewById(R.id.btnSalvarProduto);
        txtNomeCliente = findViewById(R.id.txtDescricaoProduto);
        txtCelularCliente = findViewById(R.id.txtCelularCliente);
        txtApelidoCliente = findViewById(R.id.txtApelidoCliente);
        txtCpfCliente = findViewById(R.id.txtCpf);
    }

    private void initViewModel() {
        clienteViewModel = new ViewModelProvider(this).get(ClienteViewModel.class);
    }


}