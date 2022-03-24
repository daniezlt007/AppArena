package com.deadsystem.apparena.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.deadsystem.apparena.entities.PedidoEntity;

@Dao
public interface PedidoDAORoom {

    @Insert
    Boolean insertOrder(PedidoEntity... pedidoEntities);

}
