package com.deadsystem.apparena.model;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {

    private Long id;
    private Cliente cliente;
    private List<Produto> produtos;
    private Double valorPagar;
    private Integer quantidade;
    private String tipoPagamento;

    public Pedido() {
    }

    public Pedido(Long id, Cliente cliente, List<Produto> produtos, Double valorPagar, Integer quantidade, String tipoPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorPagar = valorPagar;
        this.quantidade = quantidade;
        this.tipoPagamento = tipoPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(Double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
