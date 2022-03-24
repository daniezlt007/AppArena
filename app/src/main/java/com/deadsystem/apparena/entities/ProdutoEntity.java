package com.deadsystem.apparena.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "produto")
public class ProdutoEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    @ColumnInfo(name = "descricao")
    public String descricao;
    @ColumnInfo(name = "precocusto")
    public Double precocusto;
    @ColumnInfo(name = "tipo")
    public String tipo;
    @ColumnInfo(name = "precovenda")
    public Double precovenda;


}
