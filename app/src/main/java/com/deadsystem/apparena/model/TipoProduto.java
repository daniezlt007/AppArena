package com.deadsystem.apparena.model;

public enum TipoProduto {

    GARRAFA("Garrafa"),
    LATA("Lata"),
    CAIXA("Caixa"),
    PACOTE("Pacote");

    private String descricao;

    TipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
