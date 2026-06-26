# Senai_LLP_Transportadora

Sistema de cálculo de frete de uma transportadora utilizando conceitos de Orientação a Objetos (Herança, Polimorfismo, Classes Abstratas e Interfaces) em Java.

## Estrutura de Classes

- **`Transporte` (Interface):** Contrato para o cálculo do frete.
- **`Veiculo` (Classe Abstrata):** Classe base com atributos de veículo (ano de fabricação, marca, modelo, propulsão).
- **`VeiculoTerrestre`, `VeiculoAereo`, `VeiculoFluvial` (Classes Abstratas):** Especializações de veículos por meio.
- **`Caminhao`, `Aviao`, `PortaContainer` (Classes Finais):** Herdam seus respectivos tipos e implementam a interface `Transporte` com suas regras matemáticas específicas.

## Regras de Frete

- **Caminhão:** `(peso + (altura * largura)) * (distância * preço do diesel[6.99])`
- **Avião:** `((peso * peso) * (altura * largura)) * (distância * preço do querosene[9.99])`
- **Porta-Container:** `(peso + (altura * largura)) * distância`

## Como Executar

### Passos
1. Compile os arquivos fontes:
   ```bash
   javac src/*.java
   ```
2. Execute o programa:
   ```bash
   java -cp src Transportadora
   ```
