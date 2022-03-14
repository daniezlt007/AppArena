package com.deadsystem.apparena.dao;

import com.deadsystem.apparena.model.Cliente;

import java.util.List;

public interface ClienteDAOImplements {

    public boolean salvarCliente(Cliente cliente);
    public boolean atualizarCliente(Cliente cliente);
    public boolean deletarCliente(Cliente cliente);
    public List<Cliente> buscarTodosClientes();
    public Boolean verificaNomeDuplicadoNoBanco(String nome, String cpf);

}
