import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String nomeArquivo = "jogos.txt";
        
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.err.println("Arquivo " + nomeArquivo + " nao encontrado no diretorio atual.");
            return;
        }

        Map<String, Time> times = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;

                // Formato: rodada,timeA,timeB,resultado
                // Exemplo: 1,Flamengo,Palmeiras,2x1
                String[] partes = linha.split(",");
                if (partes.length < 4) continue;

                String timeA = partes[1].trim();
                String timeB = partes[2].trim();
                String resultado = partes[3].trim();

                String[] placar = resultado.split("x");
                if (placar.length < 2) continue;

                int golsA = Integer.parseInt(placar[0].trim());
                int golsB = Integer.parseInt(placar[1].trim());

                times.computeIfAbsent(timeA, Time::new).registrarPartida(golsA, golsB);
                times.computeIfAbsent(timeB, Time::new).registrarPartida(golsB, golsA);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao ler/processar o arquivo: " + e.getMessage());
            return;
        }

        List<Time> listaTimes = new ArrayList<>(times.values());
        Collections.sort(listaTimes);

        // Imprimir a tabela final formatada
        System.out.println("+---+--------------------+---------+-------+");
        System.out.println("| # | Time               | Pontos  | Saldo |");
        System.out.println("+---+--------------------+---------+-------+");
        for (int i = 0; i < listaTimes.size(); i++) {
            Time t = listaTimes.get(i);
            String posicao = (i + 1) + "º";
            System.out.printf("|%3s|%-20s| %-8d| %-6d|\n", 
                posicao, 
                t.getNome(), 
                t.getPontos(), 
                t.getSaldo()
            );
        }
        System.out.println("+---+--------------------+---------+-------+");
    }
}
