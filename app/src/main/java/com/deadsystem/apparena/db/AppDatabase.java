package com.deadsystem.apparena.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.deadsystem.apparena.dao.ClienteDAORoom;
import com.deadsystem.apparena.dao.ProdutoDAORoom;
import com.deadsystem.apparena.entities.ClienteEntity;
import com.deadsystem.apparena.entities.PedidoEntity;
import com.deadsystem.apparena.entities.ProdutoEntity;

@Database(entities = {ClienteEntity.class, ProdutoEntity.class, PedidoEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ClienteDAORoom clienteDAORoom();
    public abstract ProdutoDAORoom produtoDAORoom();

    public static AppDatabase INSTANCE;

    public static AppDatabase getDBInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "AppDB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }


}
