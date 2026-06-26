public abstract class VeiculoAereo extends Veiculo {
    private String registroAeronauticoBrasileiro;
    private int qtdeMotores;

    public VeiculoAereo(int anoFabricacao, String marca, String modelo, String propulsao,
                        String registroAeronauticoBrasileiro, int qtdeMotores) {
        super(anoFabricacao, marca, modelo, propulsao);
        this.registroAeronauticoBrasileiro = registroAeronauticoBrasileiro;
        this.qtdeMotores = qtdeMotores;
    }

    public String getRegistroAeronauticoBrasileiro() {
        return registroAeronauticoBrasileiro;
    }

    public void setRegistroAeronauticoBrasileiro(String registroAeronauticoBrasileiro) {
        this.registroAeronauticoBrasileiro = registroAeronauticoBrasileiro;
    }

    public int getQtdeMotores() {
        return qtdeMotores;
    }

    public void setQtdeMotores(int qtdeMotores) {
        this.qtdeMotores = qtdeMotores;
    }
}
