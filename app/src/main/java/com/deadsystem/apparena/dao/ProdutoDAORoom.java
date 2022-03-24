package com.deadsystem.apparena.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.deadsystem.apparena.model.Cliente;
import com.deadsystem.apparena.model.Produto;

import java.util.List;

@Dao
public interface ProdutoDAORoom {

    @Query("select * from produto")
    List<Produto> getAllProducts();

    @Insert
    Boolean insertProduct(Produto...produtos);

    @Update
    Boolean updateProduct(Produto produto);

    @Delete
    Boolean deleteProduct(Produto produto);

}
