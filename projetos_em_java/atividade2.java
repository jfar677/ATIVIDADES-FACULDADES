import java.util.Scanner;

public class atividade2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroAluno;
        double alturaAluno;

        int numeroMaisAlto = 0, numeroMaisBaixo = 0;
        double alturaMaisAlta = Double.MIN_VALUE;
        double alturaMaisBaixa = Double.MAX_VALUE;

        for (int i = 1; i <= 10; i++) {
            System.out.print("Digite o número do aluno " + i + ": ");
            numeroAluno = sc.nextInt();

            System.out.print("Digite a altura do aluno " + i + " (em metros): ");
            alturaAluno = sc.nextDouble();

            if (alturaAluno > alturaMaisAlta) {
                alturaMaisAlta = alturaAluno;
                numeroMaisAlto = numeroAluno;
            }

            if (alturaAluno < alturaMaisBaixa) {
                alturaMaisBaixa = alturaAluno;
                numeroMaisBaixo = numeroAluno;
            }
        }

        System.out.println("\nAluno mais alto:");
        System.out.println("Número: " + numeroMaisAlto + " | Altura: " + alturaMaisAlta + " m");

        System.out.println("\nAluno mais baixo:");
        System.out.println("Número: " + numeroMaisBaixo + " | Altura: " + alturaMaisBaixa + " m");

        sc.close();
    }
}
