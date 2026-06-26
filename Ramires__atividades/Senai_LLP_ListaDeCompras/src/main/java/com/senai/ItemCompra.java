package com.senai;

public class ItemCompra {
    private String descricao;
    private String unidade;
    private double quantidadeSugerida;
    private double precoUnitario;
    private double quantidadeComprada;
    private boolean comprado;

    public ItemCompra(String descricao, String unidade, double quantidadeSugerida) {
        this.descricao = descricao;
        this.unidade = unidade;
        this.quantidadeSugerida = quantidadeSugerida;
        this.precoUnitario = 0.0;
        this.quantidadeComprada = 0.0;
        this.comprado = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public double getQuantidadeSugerida() {
        return quantidadeSugerida;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(double quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public double getTotalItem() {
        return precoUnitario * quantidadeComprada;
    }
}
