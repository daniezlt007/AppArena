package com.deadsystem.apparena.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.dao.ClienteDAO;
import com.deadsystem.apparena.dao.ProdutoDAO;
import com.deadsystem.apparena.helper.Util;
import com.deadsystem.apparena.model.Cliente;

import java.util.List;

public class PedidoActivity extends AppCompatActivity {

    private Spinner spinner;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        initComponents();

        montaComboboxTipoProduto();


    }

    private List<Cliente> preencherComboBoxCliente(){
        ClienteDAO clienteDAO = new ClienteDAO(PedidoActivity.this);
        List<Cliente> clientes = clienteDAO.buscarTodosClientes();
        return clientes;
    }

    @NonNull
    private void montaComboboxTipoProduto() {
        List<Cliente> clientes = preencherComboBoxCliente();
        ArrayAdapter<Cliente> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, clientes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void initComponents(){
        this.spinner = findViewById(R.id.spinnerPedido);
        this.recyclerView = findViewById(R.id.recyclerViewPedido);
    }
}