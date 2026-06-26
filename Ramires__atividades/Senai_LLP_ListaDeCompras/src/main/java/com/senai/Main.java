package com.senai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static GerenciadorCompras gerenciador = new GerenciadorCompras();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            System.out.print(">> Opcao: ");
            String inputOpcao = scanner.nextLine().trim();
            try {
                opcao = Integer.parseInt(inputOpcao);
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida. Digite um numero.");
                continue;
            }

            switch (opcao) {
                case 1:
                    novaLista();
                    break;
                case 2:
                    fazerCompras();
                    break;
                case 3:
                    relatorio();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("---------------------");
        System.out.println("| Gestao de compras |");
        System.out.println("---------------------");
        System.out.println("Selecione a opcao:");
        System.out.println("1. Nova lista");
        System.out.println("2. Fazer compras");
        System.out.println("3. Relatorio");
        System.out.println("0. Sair");
    }

    private static void novaLista() {
        String dataSugerida = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now());
        String nomePadrao = "lista_" + dataSugerida;

        System.out.print(">> Nova lista, informe o nome [" + nomePadrao + "]: ");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            nome = nomePadrao;
        }

        if (gerenciador.buscarListaPorNome(nome) != null) {
            System.out.println("Ja existe uma lista com o nome \"" + nome + "\". Por favor, use outro nome.");
            return;
        }

        ListaCompras lista = new ListaCompras(nome);

        while (true) {
            System.out.println(">> ---Informe o item----------");
            System.out.print(">> Descricao: ");
            String descricao = scanner.nextLine().trim();
            if (descricao.isEmpty()) {
                break;
            }

            System.out.print(">> Unidade (UN, KG, LT): ");
            String unidade = scanner.nextLine().trim().toUpperCase();

            double quantidade = 1.0;
            System.out.print(">> Quantidade: ");
            String inputQtd = scanner.nextLine().trim();
            if (!inputQtd.isEmpty()) {
                try {
                    quantidade = Double.parseDouble(inputQtd);
                } catch (NumberFormatException e) {
                    System.out.println("Quantidade invalida. Usando padrao 1.0.");
                }
            }

            ItemCompra item = new ItemCompra(descricao, unidade, quantidade);
            lista.adicionarItem(item);
        }

        gerenciador.adicionarLista(lista);
        System.out.println(">> ---Lista salva!------------");
    }

    private static void fazerCompras() {
        if (gerenciador.getListas().isEmpty()) {
            System.out.println("Nenhuma lista cadastrada. Crie uma nova lista primeiro.");
            return;
        }

        System.out.println("Listas disponiveis:");
        for (int i = 0; i < gerenciador.getListas().size(); i++) {
            System.out.println((i + 1) + ". " + gerenciador.getListas().get(i).getNome());
        }
        System.out.print("Selecione a lista pelo numero: ");
        String inputIndex = scanner.nextLine().trim();
        int index;
        try {
            index = Integer.parseInt(inputIndex) - 1;
            if (index < 0 || index >= gerenciador.getListas().size()) {
                System.out.println("Numero de lista invalido.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida.");
            return;
        }

        ListaCompras lista = gerenciador.getListas().get(index);
        System.out.println(">> ---Fazer compras [" + lista.getNome() + "]---");

        int totalItens = lista.getItens().size();
        for (int i = 0; i < totalItens; i++) {
            ItemCompra item = lista.getItens().get(i);
            String itemStr = String.format("(%d/%d) Produto %s %s %s", 
                (i + 1), 
                totalItens, 
                item.getDescricao(), 
                formatDouble(item.getQuantidadeSugerida()), 
                item.getUnidade()
            );
            System.out.println(">> " + itemStr);

            String qtdPadraoStr = formatDouble(item.getQuantidadeSugerida());
            System.out.print(">> Quantidade [" + qtdPadraoStr + " " + item.getUnidade() + "]: ");
            String inputQtd = scanner.nextLine().trim();
            double qtdComprada = item.getQuantidadeSugerida();
            if (!inputQtd.isEmpty()) {
                try {
                    qtdComprada = Double.parseDouble(inputQtd);
                } catch (NumberFormatException e) {
                    System.out.println("Quantidade invalida. Usando quantidade sugerida.");
                }
            }

            System.out.print(">> Preco: ");
            String inputPreco = scanner.nextLine().trim();
            double preco = 0.0;
            if (!inputPreco.isEmpty()) {
                try {
                    preco = Double.parseDouble(inputPreco);
                } catch (NumberFormatException e) {
                    System.out.println("Preco invalido. Tratando como em falta (0.0).");
                }
            }

            if (preco <= 0.0) {
                item.setComprado(false);
                item.setPrecoUnitario(0.0);
                item.setQuantidadeComprada(0.0);
                System.out.println(">> Item em falta. Pulando para o proximo.");
            } else {
                item.setComprado(true);
                item.setPrecoUnitario(preco);
                item.setQuantidadeComprada(qtdComprada);
                System.out.println(">> ... ");
            }
        }

        lista.setExecutada(true);
        System.out.println(">> ---Total-------------------");
        System.out.printf(Locale.US, ">> R$: %.2f\n", lista.getValorTotalCompra());
    }

    private static void relatorio() {
        if (gerenciador.getListas().isEmpty()) {
            System.out.println("Nenhuma lista cadastrada.");
            return;
        }

        System.out.println("Listas disponiveis:");
        for (int i = 0; i < gerenciador.getListas().size(); i++) {
            System.out.println((i + 1) + ". " + gerenciador.getListas().get(i).getNome() + 
                (gerenciador.getListas().get(i).isExecutada() ? " (Comprada)" : " (Pendente)"));
        }
        System.out.print("Selecione a lista pelo numero: ");
        String inputIndex = scanner.nextLine().trim();
        int index;
        try {
            index = Integer.parseInt(inputIndex) - 1;
            if (index < 0 || index >= gerenciador.getListas().size()) {
                System.out.println("Numero de lista invalido.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida.");
            return;
        }

        ListaCompras lista = gerenciador.getListas().get(index);
        
        System.out.println(">> ---Relatorio [" + lista.getNome() + "]---");
        System.out.println(">> Item, Descricao, Qtd, UN, Preco");

        int count = 1;
        for (ItemCompra item : lista.getItens()) {
            if (item.isComprado()) {
                System.out.printf(Locale.US, ">> %d, %s, %s, %s, %.2f\n", 
                    count++, 
                    item.getDescricao(), 
                    formatDouble(item.getQuantidadeComprada()), 
                    item.getUnidade(), 
                    item.getPrecoUnitario()
                );
            }
        }
        
        System.out.printf(Locale.US, ">> 0, TOTAL, %s, UN, %.2f\n", 
            formatDouble(lista.getQuantidadeTotalItensComprados()), 
            lista.getValorTotalCompra()
        );
    }

    private static String formatDouble(double val) {
        if (val == (long) val) {
            return String.format("%d", (long) val);
        } else {
            return String.format(Locale.US, "%.2f", val);
        }
    }
}
