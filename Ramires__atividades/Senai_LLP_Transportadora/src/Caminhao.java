public class Caminhao extends VeiculoTerrestre {
    private int qtdeEixos;
    private double capacidade;
    private String carroceria;

    public Caminhao(int anoFabricacao, String marca, String modelo, String propulsao,
                    int qtdeRodas, int qtdePortas, String placa, String chassi,
                    int qtdeEixos, double capacidade, String carroceria) {
        super(anoFabricacao, marca, modelo, propulsao, qtdeRodas, qtdePortas, placa, chassi);
        this.qtdeEixos = qtdeEixos;
        this.capacidade = capacidade;
        this.carroceria = carroceria;
    }

    public int getQtdeEixos() {
        return qtdeEixos;
    }

    public void setQtdeEixos(int qtdeEixos) {
        this.qtdeEixos = qtdeEixos;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    @Override
    public double calcularFrete(double peso, double altura, double largura, double distancia) {
        return (peso + (altura * largura)) * (distancia * 6.99);
    }
}
