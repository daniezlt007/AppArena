package com.deadsystem.apparena.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.deadsystem.apparena.db.DbHelper;
import com.deadsystem.apparena.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements ProdutoDAOImplements{

    private SQLiteDatabase writeSql;
    private SQLiteDatabase readSql;

    public ProdutoDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        this.writeSql = dbHelper.getWritableDatabase();
        this.readSql = dbHelper.getReadableDatabase();
    }

    @Override
    public boolean salvarProduto(Produto produto) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("descricao", produto.getDescricao());
            cv.put("precocusto", produto.getPrecocusto());
            cv.put("tipo" , produto.getTipo());
            cv.put("precovenda", produto.getPrecovenda());
            this.writeSql.insert(DbHelper.TABLE_PRODUTO, null, cv);
        }catch (Exception e){
            Log.e("TAGDebug", "Erro: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("descricao", produto.getDescricao());
            cv.put("precocusto", produto.getPrecocusto());
            cv.put("tipo" , produto.getTipo());
            cv.put("precovenda", produto.getPrecovenda());
            String[] args = {produto.getId().toString()};
            this.writeSql.update(DbHelper.TABLE_PRODUTO, cv, "id=?", args);
        }catch (Exception e){
            Log.e("TAGDebug", "Erro ao atualizar produto: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletarProduto(Produto produto) {
        try{
            String[] args = {produto.getId().toString()};
            writeSql.delete(DbHelper.TABLE_PRODUTO, "id=?", args);
        }catch (Exception e){
            Log.e("INFO", "Erro ao excluir produto: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Produto> buscarTodosProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from " + DbHelper.TABLE_PRODUTO + ";";
        Cursor cursor = readSql.rawQuery(sql, null);
        while (cursor.moveToNext()){
            Produto produto = new Produto();

            Long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
            String descricao = cursor.getString(cursor.getColumnIndexOrThrow("descricao"));
            Double precocusto = cursor.getDouble(cursor.getColumnIndexOrThrow("precocusto"));
            String tipo = cursor.getString(cursor.getColumnIndexOrThrow("tipo"));
            Double precovenda = cursor.getDouble(cursor.getColumnIndexOrThrow("precovenda"));

            produto.setId(id);
            produto.setDescricao(descricao);
            produto.setPrecocusto(precocusto);
            produto.setTipo(tipo);
            produto.setPrecovenda(precovenda);
            produtos.add(produto);
        }
        cursor.close();
        return produtos;
    }

    @Override
    public Boolean verificaNomeDuplicadoNoBanco(String nome, String tipo) {
        String sql = "descricao=?  and tipo=?";
        String[] columns = {"descricao", "tipo"};
        String[] args = {nome, tipo};
        Cursor cursor = this.readSql.query(DbHelper.TABLE_PRODUTO, columns, sql, args, null, null, null);
        int count = cursor.getCount();
        if(count > 0){
            return true;
        }
        return false;
    }

}
