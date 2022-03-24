package com.deadsystem.apparena.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import java.io.Serializable;

@Entity(tableName = "pedido",
        primaryKeys = {"clienteid", "produtoid"},
        foreignKeys = {
                @ForeignKey(entity = ClienteEntity.class,
                        parentColumns = "id",
                        childColumns = "clienteid"),
                @ForeignKey(entity = ProdutoEntity.class,
                        parentColumns = "id",
                        childColumns = "produtoid")})
public class PedidoEntity implements Serializable {

    @ColumnInfo(name = "clienteid")
    @NonNull
    public Long cliente;
    @ColumnInfo(name = "produtoid")
    @NonNull
    public Long produto;
    @ColumnInfo(name = "valorPagar")
    public Double valorPagar;
    @ColumnInfo(name = "quantidade")
    public Integer quantidade;
    @ColumnInfo(name = "tipoPagamento")
    public String tipoPagamento;
    @ColumnInfo(name = "orderid")
    public String uuid;


}
