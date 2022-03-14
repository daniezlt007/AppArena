package com.deadsystem.apparena.model;

import java.io.Serializable;

public class Cliente implements Serializable {

    private Long id;
    private String nomeCliente;
    private String telefoneCliente;
    private String apelidoCliente;
    private String cpfcliente;

    public Cliente() {

    }

    public Cliente(String nomeCliente, String telefoneCliente, String apelidoCliente, String cpfcliente){
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.apelidoCliente = apelidoCliente;
        this.cpfcliente = cpfcliente;
    }

    public Cliente(Long id, String nomeCliente, String telefoneCliente, String apelidoCliente, String cpfcliente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.apelidoCliente = apelidoCliente;
        this.cpfcliente = cpfcliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getApelidoCliente() {
        return apelidoCliente;
    }

    public void setApelidoCliente(String apelidoCliente) {
        this.apelidoCliente = apelidoCliente;
    }

    public String getCpfcliente() {
        return cpfcliente;
    }

    public void setCpfcliente(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    @Override
    public String toString() {
        return id + " - " + nomeCliente;
    }
}
