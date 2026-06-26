# Senai_LLP_Email

Programa para contagem de e-mails válidos únicos baseados nas regras do LeetCode.

## Regras de Normalização (Nome Local)
1. **Pontos `.`.** São ignorados no nome local (ex: `alice.z@leetcode.com` se torna `alicez@leetcode.com`).
2. **Sinal de Mais `+`.** Ignora tudo após o primeiro sinal de mais no nome local (ex: `m.y+name@email.com` se torna `my@email.com`).
3. Estas regras **não** se aplicam ao nome de domínio.

## Como Executar

### Passos
1. Compile o arquivo fonte:
   ```bash
   javac src/EmailUnico.java
   ```
2. Execute o programa com os e-mails como argumentos:
   ```bash
   java -cp src EmailUnico email1@exemplo.com email.2+teste@exemplo.com
   ```
3. Ou simplesmente execute sem argumentos para rodar os casos de testes integrados e o modo interativo:
   ```bash
   java -cp src EmailUnico
   ```
