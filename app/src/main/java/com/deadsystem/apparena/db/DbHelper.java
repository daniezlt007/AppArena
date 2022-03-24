package com.deadsystem.apparena.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "arena.db";
    public static final String TABLE_CLIENTE = "clientes";
    public static final String TABLE_PRODUTO = "produtos";
    public static final String TABLE_PEDIDO = "pedidos";

    private static final String CREATE_TABLE_PRODUTOS = "CREATE TABLE produtos (id INTEGER PRIMARY KEY," +
            " descricao TEXT NOT NULL, precovenda REAL NOT NULL, tipo TEXT NOT NULL, precocusto)";
    private static final String CREATE_TABLE_CLIENTES = "CREATE TABLE clientes (id INTEGER PRIMARY KEY," +
            "nome TEXT NOT NULL, telefone TEXT NOT NULL, apelido TEXT NOT NULL, cpf TEXT NOT NULL)";
    private static final String CREATE_TABLE_PEDIDOS = "CREATE TABLE pedidos (id INTEGER PRIMARY KEY," +
            "cliente_id INTEGER NOT NULL, telefone TEXT NOT NULL, apelido TEXT NOT NULL, cpf TEXT NOT NULL)";


    /*
    private Long id;
    private Cliente cliente;
    private List<Produto> produtos;
    private Double valorPagar;
    private Integer quantidade;
    private String tipoPagamento;*/


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.execSQL(CREATE_TABLE_CLIENTES);
        db.execSQL(CREATE_TABLE_PRODUTOS);
        db.execSQL(CREATE_TABLE_PEDIDOS);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
