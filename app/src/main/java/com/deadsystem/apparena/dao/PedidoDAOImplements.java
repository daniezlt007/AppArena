package com.deadsystem.apparena.dao;

import com.deadsystem.apparena.model.Pedido;

import java.util.List;

public interface PedidoDAOImplements {

    public boolean salvarProduto(Pedido pedido);
    public boolean atualizarProduto(Pedido pedido);
    public boolean deletarProduto(Pedido pedido);
    public List<Pedido> buscarTodosPedidos();

}
