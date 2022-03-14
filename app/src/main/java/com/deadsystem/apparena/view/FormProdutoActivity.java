package com.deadsystem.apparena.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.deadsystem.apparena.R;
import com.deadsystem.apparena.dao.ProdutoDAO;
import com.deadsystem.apparena.helper.Util;
import com.deadsystem.apparena.model.Produto;
import com.deadsystem.apparena.model.TipoProduto;

import java.util.ArrayList;
import java.util.List;

public class FormProdutoActivity extends AppCompatActivity {

    private Button btnSalvarProduto;
    private Spinner spinner;
    private EditText txtDescricaoProduto, txtValorProduto, txtPrecoCusto;
    private Produto produtoAtual;
    private ProdutoDAO produtoDAO;
    private Long id = 0l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_produto);
        initComponents();

        List<String> tipos = montaComboboxTipoProduto();
        produtoAtual = (Produto)getIntent().getSerializableExtra("produtoSelecionado");
        if(produtoAtual != null){
            btnSalvarProduto.setText(R.string.btn_atualizar);
            id = produtoAtual.getId();
            txtDescricaoProduto.setText(produtoAtual.getDescricao());
            txtPrecoCusto.setText(produtoAtual.getPrecocusto().toString());
            txtValorProduto.setText(produtoAtual.getPrecovenda().toString());
            spinner.setSelection(Util.retornaPosicaoSpinnerTipos(produtoAtual.getTipo()));
        }
        produtoDAO = new ProdutoDAO(FormProdutoActivity.this);
        btnSalvarProduto.setOnClickListener(view -> {
            if(produtoAtual != null){
                String descricao = txtDescricaoProduto.getText().toString().toUpperCase();
                Double precoCusto = Double.parseDouble(txtPrecoCusto.getText().toString());
                Double precoVenda = Double.parseDouble(txtValorProduto.getText().toString());
                int posicao = spinner.getSelectedItemPosition();
                String tipoProduto = tipos.get(posicao);

                produtoAtual = new Produto(id, descricao, precoCusto, tipoProduto, precoVenda);
                if(produtoDAO.atualizarProduto(produtoAtual)){
                    Toast.makeText(FormProdutoActivity.this, "Atualizado com sucesso.", Toast.LENGTH_LONG).show();
                    finish();
                }
            } else {
                String descricao = txtDescricaoProduto.getText().toString().toUpperCase();
                Double precoCusto = Double.parseDouble(txtPrecoCusto.getText().toString());
                Double precoVenda = Double.parseDouble(txtValorProduto.getText().toString());
                int posicao = spinner.getSelectedItemPosition();
                String tipoProduto = tipos.get(posicao);
                produtoAtual = new Produto(descricao, precoCusto, tipoProduto, precoVenda);
                if(produtoDAO.verificaNomeDuplicadoNoBanco(produtoAtual.getDescricao().toUpperCase(), produtoAtual.getTipo())){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(FormProdutoActivity.this);
                    dialog.setTitle("Erro");
                    dialog.setMessage("Produto com o nome: \n" + produtoAtual.getDescricao() + " já está cadastrado");
                    dialog.setPositiveButton("Ok", null);
                    dialog.create();
                    dialog.show();
                    produtoAtual = null;
                }else{
                    if(produtoDAO.salvarProduto(produtoAtual)){
                        Toast.makeText(FormProdutoActivity.this, "Salvo com sucesso.", Toast.LENGTH_LONG).show();
                        finish();
                    }else{
                        Toast.makeText(FormProdutoActivity.this, "Erro ao salvar produto.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @NonNull
    private List<String> montaComboboxTipoProduto() {
        List<String> tipos = preencherSpinner();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tipos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return tipos;
    }

    private void initComponents(){
        spinner = findViewById(R.id.spinner);
        btnSalvarProduto = findViewById(R.id.btnSalvarProduto);
        txtDescricaoProduto = findViewById(R.id.txtDescricaoProduto);
        txtValorProduto = findViewById(R.id.txtValorProduto);
        txtPrecoCusto = findViewById(R.id.txtPrecoCusto);
    }

    private List<String> preencherSpinner(){
        List<String> tipos = new ArrayList<>();
        tipos.add("Selecione um tipo");
        tipos.add(TipoProduto.CAIXA.getDescricao());
        tipos.add(TipoProduto.GARRAFA.getDescricao());
        tipos.add(TipoProduto.LATA.getDescricao());
        tipos.add(TipoProduto.PACOTE.getDescricao());
        return tipos;
    }



}