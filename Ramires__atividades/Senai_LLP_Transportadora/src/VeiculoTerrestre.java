public abstract class VeiculoTerrestre extends Veiculo {
    private int qtdeRodas;
    private int qtdePortas;
    private String placa;
    private String chassi;

    public VeiculoTerrestre(int anoFabricacao, String marca, String modelo, String propulsao,
                            int qtdeRodas, int qtdePortas, String placa, String chassi) {
        super(anoFabricacao, marca, modelo, propulsao);
        this.qtdeRodas = qtdeRodas;
        this.qtdePortas = qtdePortas;
        this.placa = placa;
        this.chassi = chassi;
    }

    public int getQtdeRodas() {
        return qtdeRodas;
    }

    public void setQtdeRodas(int qtdeRodas) {
        this.qtdeRodas = qtdeRodas;
    }

    public int getQtdePortas() {
        return qtdePortas;
    }

    public void setQtdePortas(int qtdePortas) {
        this.qtdePortas = qtdePortas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
}
