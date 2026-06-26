# Senai_LLP_ListaDeCompras

Sistema de Gestão de Compras desenvolvido em Java utilizando programação orientada a objetos (POO) e Maven.

## Funcionalidades
1. **Nova Lista:** Criação de uma lista de compras sugerindo o nome como `lista_[anomesdia]` e adição de itens (descrição, unidade: UN, KG, LT e quantidade sugerida) até o usuário informar uma descrição em branco.
2. **Fazer Compras:** Seleção de uma lista criada para informar a quantidade comprada de cada item (com sugestão da quantidade informada na criação) e o preço unitário. Caso o preço seja `0`, o item é tratado como em falta. Ao final da lista de itens, o programa calcula o valor total gasto.
3. **Relatório:** Seleção de uma lista de compras para visualização dos itens comprados, quantidades, preço unitário de cada um, além do total geral acumulado.

## Como Executar

### Passos
1. Certifique-se de possuir o Maven instalado.
2. No diretório do projeto, compile e construa o pacote:
   ```bash
   mvn clean package
   ```
3. Execute o programa usando o plugin do Maven:
   ```bash
   mvn exec:java
   ```
   Ou execute diretamente utilizando o Java:
   ```bash
   java -cp target/Senai_LLP_ListaDeCompras-1.0-SNAPSHOT.jar com.senai.Main
   ```
