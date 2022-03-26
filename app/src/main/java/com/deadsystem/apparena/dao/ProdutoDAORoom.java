package com.deadsystem.apparena.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.deadsystem.apparena.entities.ProdutoEntity;
import com.deadsystem.apparena.model.Cliente;
import com.deadsystem.apparena.model.Produto;

import java.util.List;

@Dao
public interface ProdutoDAORoom {

    @Query("select * from produto")
    List<ProdutoEntity> getAllProducts();

    @Insert
    void insertProduct(ProdutoEntity...produtos);

    @Update
    void updateProduct(ProdutoEntity produto);

    @Delete
    void deleteProduct(ProdutoEntity produto);

}
