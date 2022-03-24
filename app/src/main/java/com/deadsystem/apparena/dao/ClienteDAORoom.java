package com.deadsystem.apparena.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.deadsystem.apparena.entities.ClienteEntity;
import com.deadsystem.apparena.model.Cliente;

import java.util.List;

@Dao
public interface ClienteDAORoom {

    @Query("select * from cliente")
    List<ClienteEntity> getAllClients();

    @Insert
    void insertClient(ClienteEntity... clientes);

    @Update
    void updateClient(ClienteEntity cliente);

    @Delete
    void deleteClient(ClienteEntity cliente);

}
