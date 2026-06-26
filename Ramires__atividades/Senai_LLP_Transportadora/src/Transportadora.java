import java.util.Locale;
import java.util.Scanner;

public class Transportadora {
    
    public double calcularValorFrete(Transporte transporte, double peso, double altura, double largura, double distancia) {
        return transporte.calcularFrete(peso, altura, largura, distancia);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("          CALCULO DE FRETE - TRANSPORTADORA      ");
        System.out.println("=================================================");
        
        System.out.print("Digite o peso da encomenda (kg): ");
        double peso = sc.nextDouble();
        
        System.out.print("Digite a altura da encomenda (m): ");
        double altura = sc.nextDouble();
        
        System.out.print("Digite a largura da encomenda (m): ");
        double largura = sc.nextDouble();
        
        System.out.print("Digite a distancia do frete (km): ");
        double distancia = sc.nextDouble();

        // Instanciando veiculos de teste com dados arbitrarios
        Caminhao caminhao = new Caminhao(2022, "Volvo", "FH 540", "Diesel", 
                                         6, 2, "ABC-1234", "123456789ABCDEF", 
                                         3, 25000.0, "Bau");

        Aviao aviao = new Aviao(2018, "Boeing", "747-8F", "Querosene", 
                                "PP-XYZ", 4, 
                                134000.0, 442000.0);

        PortaContainer navio = new PortaContainer(2020, "Maersk", "Triple E", "Oleo Combustivel", 
                                                 "IMO 9632064", 59.0, 73.0, 
                                                 18000, "Panamax");

        Transportadora transportadora = new Transportadora();

        double freteCaminhao = transportadora.calcularValorFrete(caminhao, peso, altura, largura, distancia);
        double freteAviao = transportadora.calcularValorFrete(aviao, peso, altura, largura, distancia);
        double freteNavio = transportadora.calcularValorFrete(navio, peso, altura, largura, distancia);

        System.out.println("\n=================================================");
        System.out.println("               RESULTADOS DO ORCAMENTO           ");
        System.out.println("=================================================");
        System.out.printf("Frete via Caminhao:       R$ %,.2f\n", freteCaminhao);
        System.out.printf("Frete via Aviao:          R$ %,.2f\n", freteAviao);
        System.out.printf("Frete via Porta-Container: R$ %,.2f\n", freteNavio);
        System.out.println("=================================================");

        sc.close();
    }
}
