import java.util.Scanner;

public class RomanoParaInt {

    public static int AlgarismoRomanoParaInteiro(String s) {
        int total = 0;
        int prevValue = 0;

        // Limpa espaços e coloca em maiúsculo
        s = s.trim().toUpperCase();

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int currentValue = 0;

            switch (c) {
                case 'I': currentValue = 1; break;
                case 'V': currentValue = 5; break;
                case 'X': currentValue = 10; break;
                case 'L': currentValue = 50; break;
                case 'C': currentValue = 100; break;
                case 'D': currentValue = 500; break;
                case 'M': currentValue = 1000; break;
                default:
                    // Ignora caracteres inválidos ou trata como 0
                    currentValue = 0;
                    break;
            }

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }

        return total;
    }

    public static void main(String[] args) {
        // Passando argumento
        if (args.length > 0) {
            String algarismos = String.join("", args);
            int valor = AlgarismoRomanoParaInteiro(algarismos);
            System.out.println(valor);
            return;
        }

        // Por pipe | ou interacao com usuario
        Scanner sc = new Scanner(System.in);
        System.out.print("informe o algarismo: ");
        if (sc.hasNextLine()) {
            String algarismos = sc.nextLine();
            int valor = AlgarismoRomanoParaInteiro(algarismos);
            System.out.println(valor);
        }
        sc.close();
    }
}
