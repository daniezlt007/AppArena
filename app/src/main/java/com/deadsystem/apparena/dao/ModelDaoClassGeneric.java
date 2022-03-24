package com.deadsystem.apparena.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.deadsystem.apparena.model.Cliente;
import com.deadsystem.apparena.model.Pedido;
import com.deadsystem.apparena.model.Produto;

import java.util.List;

@Dao
public interface ModelDaoClassGeneric {

    //Cliente
    @Query("select * from ClienteEntity")
    List<Cliente> getAllClients();

    @Insert
    Boolean insertClient(Cliente...clientes);

    @Update
    Boolean updateClient(Cliente cliente);

    @Delete
    Boolean deleteClient(Cliente cliente);

    //Produto
    @Query("select * from ClienteEntity")
    List<Produto> getAllProducts();

    @Insert
    Boolean insertProduct(Cliente...clientes);

    @Update
    Boolean updateProduct(Cliente cliente);

    @Delete
    Boolean deleteProduct(Cliente cliente);

    //Pedido
    @Query("select * from PedidoEntity where cliente_id = :id")
    List<Pedido> getAllOrders(Long id);

    @Insert
    Boolean insertOrder(Pedido...pedidos);

    @Update
    Boolean updateOrder(Pedido pedido);

    @Delete
    Boolean deleteOrder(Pedido pedido);

}
