package com.deadsystem.apparena.dao;

import com.deadsystem.apparena.model.Cliente;
import com.deadsystem.apparena.model.Produto;

import java.util.List;

public interface ProdutoDAOImplements {

    public boolean salvarProduto(Produto produto);
    public boolean atualizarProduto(Produto produto);
    public boolean deletarProduto(Produto produto);
    public List<Produto> buscarTodosProdutos();
    public Boolean verificaNomeDuplicadoNoBanco(String nome, String tipo);

}
