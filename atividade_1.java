public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java Main \"seu texto aqui\"");
            return;
        }

        String texto = String.join(" ", args).trim();

        if (texto.isEmpty()) {
            System.out.println("Texto vazio.");
            return;
        }

        String[] palavras = texto.split("\\s+");
        int quantidadePalavras = palavras.length;

        int quantidadeVogais = contarVogaisSemAcento(texto);

        int palavrasComLetrasPares = 0;
        int palavrasComLetrasImpares = 0;

        for (String palavra : palavras) {
            String somenteLetras = palavra.replaceAll("[^A-Za-z]", "");
            int tamanho = somenteLetras.length();

            if (tamanho == 0) {
                continue;
            }

            if (tamanho % 2 == 0) {
                palavrasComLetrasPares++;
            } else {
                palavrasComLetrasImpares++;
            }
        }

        System.out.println("Texto informado: " + texto);
        System.out.println("Quantidade de palavras: " + quantidadePalavras);
        System.out.println("Quantidade de vogais (sem acentos): " + quantidadeVogais);
        System.out.println("Palavras com quantidade de letras pares: " + palavrasComLetrasPares);
        System.out.println("Palavras com quantidade de letras ímpares: " + palavrasComLetrasImpares);
    }

    private static int contarVogaisSemAcento(String texto) {
        int contador = 0;
        String minusculo = texto.toLowerCase();

        for (int i = 0; i < minusculo.length(); i++) {
            char c = minusculo.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++;
            }
        }

        return contador;
    }
}
