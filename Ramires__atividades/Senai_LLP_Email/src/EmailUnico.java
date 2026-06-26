import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EmailUnico {

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            if (email == null) continue;
            
            // Separa em local e dominio
            int atIndex = email.indexOf('@');
            if (atIndex == -1) continue;

            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex + 1);

            // Regra do sinal de mais '+': ignora tudo apos o sinal
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            // Regra do ponto '.': remove os pontos do nome local
            local = local.replace(".", "");

            // Junta local e dominio normalizados
            uniqueEmails.add(local + "@" + domain);
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        // Exemplo 1 caso nao seja passado argumentos
        if (args.length == 0) {
            System.out.println("Nenhum argumento fornecido. Rodando com exemplos padrao:");
            String[] exemplo1 = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
            };
            System.out.println("Exemplo 1 (esperado: 2): " + numUniqueEmails(exemplo1));

            String[] exemplo2 = {
                "a@leetcode.com",
                "b@leetcode.com",
                "c@leetcode.com"
            };
            System.out.println("Exemplo 2 (esperado: 3): " + numUniqueEmails(exemplo2));

            // Modo interativo
            Scanner sc = new Scanner(System.in);
            System.out.println("\nDigite os e-mails para processar (separados por virgula ou espaco):");
            if (sc.hasNextLine()) {
                String input = sc.nextLine();
                String[] emails = input.split("[,\\s]+");
                System.out.println("Quantidade de e-mails unicos: " + numUniqueEmails(emails));
            }
            sc.close();
        } else {
            // Executa com argumentos de linha de comando
            int unicos = numUniqueEmails(args);
            System.out.println("Quantidade de e-mails unicos: " + unicos);
        }
    }
}
