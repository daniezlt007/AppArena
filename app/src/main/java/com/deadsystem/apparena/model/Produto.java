package com.deadsystem.apparena.model;

import java.io.Serializable;

public class Produto implements Serializable {

    private Long id;
    private String descricao;
    private Double precocusto;
    private String tipo;
    private Double precovenda;

    public Produto() {

    }

    public Produto(String descricao, Double precocusto, String tipo, Double precovenda) {
        this.descricao = descricao;
        this.precocusto = precocusto;
        this.tipo = tipo;
        this.precovenda = precovenda;
    }

    public Produto(Long id, String descricao, Double precocusto, String tipo, Double precovenda) {
        this.id = id;
        this.descricao = descricao;
        this.precocusto = precocusto;
        this.tipo = tipo;
        this.precovenda = precovenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(Double precocusto) {
        this.precocusto = precocusto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(Double precovenda) {
        this.precovenda = precovenda;
    }
}
