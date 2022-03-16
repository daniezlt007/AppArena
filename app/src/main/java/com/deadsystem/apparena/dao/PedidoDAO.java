package com.deadsystem.apparena.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.deadsystem.apparena.db.DbHelper;
import com.deadsystem.apparena.model.Pedido;

import java.util.List;

public class PedidoDAO implements PedidoDAOImplements{

    private SQLiteDatabase writeSql;
    private SQLiteDatabase readSql;

    public PedidoDAO(SQLiteDatabase writeSql, SQLiteDatabase readSql) {
        this.writeSql = writeSql;
        this.readSql = readSql;
    }

    @Override
    public boolean salvarProduto(Pedido pedido) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("descricao", pedido.getCliente().getId());
            cv.put("precocusto", pedido.getQuantidade());
            cv.put("tipo" , pedido.getValorPagar());
            cv.put("precovenda", pedido.getTipoPagamento());
            cv.put("precovenda", pedido.getProdutos().get(0).getId());
            this.writeSql.insert(DbHelper.TABLE_PRODUTO, null, cv);
        }catch (Exception e){
            Log.e("TAGDebug", "Erro: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizarProduto(Pedido pedido) {
        return false;
    }

    @Override
    public boolean deletarProduto(Pedido pedido) {
        return false;
    }

    @Override
    public List<Pedido> buscarTodosPedidos() {
        return null;
    }
}
