package com.deadsystem.apparena.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.deadsystem.apparena.db.DbHelper;
import com.deadsystem.apparena.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements ClienteDAOImplements {

    private SQLiteDatabase writeSql;
    private SQLiteDatabase readSql;

    public ClienteDAO(Context context){
        DbHelper dbHelper = new DbHelper(context);
        this.writeSql = dbHelper.getWritableDatabase();
        this.readSql = dbHelper.getReadableDatabase();
    }


    @Override
    public boolean salvarCliente(Cliente cliente) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("nome",cliente.getNomeCliente());
            cv.put("apelido", cliente.getApelidoCliente());
            cv.put("telefone", cliente.getTelefoneCliente());
            cv.put("cpf", cliente.getCpfcliente());
            this.writeSql.insert(DbHelper.TABLE_CLIENTE, null, cv);
        }catch (Exception e){
            Log.e("TAGDebug", "Erro: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizarCliente(Cliente cliente) {
        try {
            ContentValues cv = new ContentValues();
            cv.put("nome",cliente.getNomeCliente());
            cv.put("apelido", cliente.getApelidoCliente());
            cv.put("telefone", cliente.getTelefoneCliente());
            cv.put("cpf", cliente.getCpfcliente());
            String[] args = {cliente.getId().toString()};
            this.writeSql.update(DbHelper.TABLE_CLIENTE, cv, "id=?", args);
        }catch (Exception e){
            Log.e("TAGDebug", "Erro ao atualizar cliente: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletarCliente(Cliente cliente) {
        try{
            String[] args = {cliente.getId().toString()};
            writeSql.delete(DbHelper.TABLE_CLIENTE, "id=?", args);
        }catch (Exception e){
            Log.e("INFO", "Erro ao excluir cliente: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "select * from " + DbHelper.TABLE_CLIENTE + ";";
        Cursor cursor = readSql.rawQuery(sql, null);
        while (cursor.moveToNext()){
            Cliente cliente = new Cliente();

            Long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
            String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            String telefone = cursor.getString(cursor.getColumnIndexOrThrow("telefone"));
            String apelido = cursor.getString(cursor.getColumnIndexOrThrow("apelido"));
            String cpfcliente = cursor.getString(cursor.getColumnIndexOrThrow("cpf"));

            cliente.setId(id);
            cliente.setNomeCliente(nome);
            cliente.setTelefoneCliente(telefone);
            cliente.setApelidoCliente(apelido);
            cliente.setCpfcliente(cpfcliente);
            clientes.add(cliente);
        }
        cursor.close();
        return clientes;
    }

    @Override
    public Boolean verificaNomeDuplicadoNoBanco(String nome, String cpf) {
        String sql = "nome=?  and cpf=?";
        String[] columns = {"nome", "cpf"};
        String[] args = {nome, cpf};
        Cursor cursor = this.readSql.query(DbHelper.TABLE_CLIENTE, columns, sql, args, null, null, null);
        int count = cursor.getCount();
        if(count > 0){
            return true;
        }
        return false;
    }
}
