import java.io.*;
import java.util.*;

public class atividade_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome da receita: ");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nenhum nome informado.");
            return;
        }

        List<String> ingredientes = new ArrayList<>();
        for (int i = 1; ; i++) {
            System.out.print("Descrição do ingrediente (ENTER para terminar): ");
            String desc = scanner.nextLine().trim();
            if (desc.isEmpty()) break;
            System.out.print("Quantidade do ingrediente: ");
            String qtd = scanner.nextLine().trim();
            ingredientes.add(i + ". " + desc + " - " + (qtd.isEmpty() ? "(quantidade não informada)" : qtd));
        }

        List<String> instrucoes = new ArrayList<>();
        for (int i = 1; ; i++) {
            System.out.print("Passo " + i + " (ENTER para terminar): ");
            String passo = scanner.nextLine().trim();
            if (passo.isEmpty()) break;
            instrucoes.add("Passo " + i + ": " + passo);
        }
        scanner.close();

        String arquivo = nome.replaceAll("[\\/:*?\"<>|]", "").trim();
        if (arquivo.isEmpty()) arquivo = "receita";
        if (!arquivo.toLowerCase().endsWith(".txt")) arquivo += ".txt";

        try (PrintWriter out = new PrintWriter(arquivo)) {
            out.println(nome);
            out.println();
            ingredientes.forEach(out::println);
            out.println();
            instrucoes.forEach(out::println);
            System.out.println("Receita salva em: " + arquivo);
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
}
