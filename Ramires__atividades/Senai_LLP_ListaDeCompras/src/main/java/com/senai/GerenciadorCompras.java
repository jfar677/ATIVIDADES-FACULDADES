package com.senai;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorCompras {
    private List<ListaCompras> listas;

    public GerenciadorCompras() {
        this.listas = new ArrayList<>();
    }

    public void adicionarLista(ListaCompras lista) {
        this.listas.add(lista);
    }

    public List<ListaCompras> getListas() {
        return listas;
    }

    public ListaCompras buscarListaPorNome(String nome) {
        for (ListaCompras l : listas) {
            if (l.getNome().equalsIgnoreCase(nome)) {
                return l;
            }
        }
        return null;
    }
}
