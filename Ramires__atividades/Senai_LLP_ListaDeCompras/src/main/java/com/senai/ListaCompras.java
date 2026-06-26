package com.senai;

import java.util.ArrayList;
import java.util.List;

public class ListaCompras {
    private String nome;
    private List<ItemCompra> itens;
    private boolean executada;

    public ListaCompras(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
        this.executada = false;
    }

    public String getNome() {
        return nome;
    }

    public List<ItemCompra> getItens() {
        return itens;
    }

    public void adicionarItem(ItemCompra item) {
        this.itens.add(item);
    }

    public boolean isExecutada() {
        return executada;
    }

    public void setExecutada(boolean executada) {
        this.executada = executada;
    }

    public double getValorTotalCompra() {
        double total = 0;
        for (ItemCompra item : itens) {
            if (item.isComprado()) {
                total += item.getTotalItem();
            }
        }
        return total;
    }

    public double getQuantidadeTotalItensComprados() {
        double total = 0;
        for (ItemCompra item : itens) {
            if (item.isComprado()) {
                total += item.getQuantidadeComprada();
            }
        }
        return total;
    }
}
