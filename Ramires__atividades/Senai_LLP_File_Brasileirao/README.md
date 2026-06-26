# Senai_LLP_File_Brasileirao

Sistema de Classificação de Campeonato de Futebol em Java.

## Objetivo
Este programa lê um arquivo de texto chamado `jogos.txt` contendo os resultados das partidas de futebol, processa as pontuações e exibe a tabela de classificação final ordenada conforme os critérios de pontos e saldo de gols (desempate).

## Regras de Pontuação
- **Vitória:** 3 pontos
- **Empate:** 1 ponto
- **Derrota:** 0 pontos
- **Saldo de Gols:** Gols Feitos - Gols Sofridos (Critério de desempate)

## Como Executar

### Pré-requisitos
- JDK 8 ou superior instalado.

### Passos
1. Certifique-se de que o arquivo `jogos.txt` está no mesmo diretório do arquivo executável.
2. Compile os arquivos fontes:
   ```bash
   javac src/*.java
   ```
3. Execute o programa:
   ```bash
   java -cp src Main
   ```

## Exemplo de Saída
```
+---+--------------------+---------+-------+
| # | Time               | Pontos  | Saldo |
+---+--------------------+---------+-------+
| 1º| Flamengo           | 4       | 1     |
| 2º| Palmeiras          | 3       | 2     |
...
+---+--------------------+---------+-------+
```
