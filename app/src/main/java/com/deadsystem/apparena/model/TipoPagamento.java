package com.deadsystem.apparena.model;

public enum TipoPagamento {

    CARTAO_CREDITO("Cartão Crédito"),
    CARTAO_DEBITO("Cartão Débito"),
    DINHEIRO("Dinheiro"),
    PIX("Pix"),
    ;

    private String descricao;

    TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
