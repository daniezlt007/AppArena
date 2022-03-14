package com.deadsystem.apparena.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.dao.ClienteDAO;
import com.deadsystem.apparena.model.Cliente;

public class FormClientActivity extends AppCompatActivity {

    private Button btnSalvarCliente;
    private TextView txtNomeCliente, txtCelularCliente, txtApelidoCliente, txtCpfCliente;
    private Cliente clienteAtual;
    private Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_client);

        initComponents();

        clienteAtual = (Cliente) getIntent().getSerializableExtra("clienteSelecionado");
        if (clienteAtual != null) {
            btnSalvarCliente.setText(R.string.btn_atualizar);
            id = clienteAtual.getId();
            txtNomeCliente.setText(clienteAtual.getNomeCliente());
            txtCelularCliente.setText(clienteAtual.getTelefoneCliente());
            txtCpfCliente.setText(clienteAtual.getCpfcliente());
            txtApelidoCliente.setText(clienteAtual.getApelidoCliente());
        }
        ClienteDAO clienteDAO = new ClienteDAO(FormClientActivity.this);
        btnSalvarCliente.setOnClickListener(view1 -> {
            if(clienteAtual != null){
                String nomeCliente = txtNomeCliente.getText().toString().toUpperCase();
                String celularCliente = txtCelularCliente.getText().toString();
                String cpfCliente = txtCelularCliente.getText().toString();
                String apelidoCliente = txtApelidoCliente.getText().toString();

                clienteAtual = new Cliente(id, nomeCliente, celularCliente, cpfCliente, apelidoCliente);

                if (clienteDAO.atualizarCliente(clienteAtual)) {
                    Toast.makeText(FormClientActivity.this, "Atualizado com sucesso.", Toast.LENGTH_LONG).show();
                    finish();
                }
            } else {
                clienteAtual = montaObjetoCliente();
                if(clienteDAO.verificaNomeDuplicadoNoBanco(clienteAtual.getNomeCliente(), clienteAtual.getCpfcliente())){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(FormClientActivity.this);
                    dialog.setTitle("Erro");
                    dialog.setMessage("Cliente com o nome: \n" + clienteAtual.getNomeCliente() + " já está cadastrado");
                    dialog.setPositiveButton("Ok", null);
                    dialog.create();
                    dialog.show();
                    clienteAtual = null;
                }else {
                    if (clienteDAO.salvarCliente(clienteAtual)) {
                        Toast.makeText(FormClientActivity.this, "Salvo com sucesso.", Toast.LENGTH_LONG).show();
                        finish();
                    }
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

    private Cliente montaObjetoCliente() {
        String nome = txtNomeCliente.getText().toString().toUpperCase();
        String celular = txtCelularCliente.getText().toString();
        String apelido = txtApelidoCliente.getText().toString();
        String cpf = txtCpfCliente.getText().toString();
        return new Cliente(nome, celular, apelido, cpf);
    }


}