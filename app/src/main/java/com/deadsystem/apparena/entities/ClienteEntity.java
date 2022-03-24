package com.deadsystem.apparena.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.deadsystem.apparena.model.Cliente;

import java.io.Serializable;

@Entity(tableName = "cliente")
public class ClienteEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    @ColumnInfo(name="nomeCliente")
    public String nomeCliente;
    @ColumnInfo(name="telefoneCliente")
    public String telefoneCliente;
    @ColumnInfo(name="apelidoCliente")
    public String apelidoCliente;
    @ColumnInfo(name="cpfcliente")
    public String cpfcliente;


}
