public abstract class VeiculoFluvial extends Veiculo {
    private String numRegistroMarinha;
    private double boca;
    private double caladoAereo;

    public VeiculoFluvial(int anoFabricacao, String marca, String modelo, String propulsao,
                          String numRegistroMarinha, double boca, double caladoAereo) {
        super(anoFabricacao, marca, modelo, propulsao);
        this.numRegistroMarinha = numRegistroMarinha;
        this.boca = boca;
        this.caladoAereo = caladoAereo;
    }

    public String getNumRegistroMarinha() {
        return numRegistroMarinha;
    }

    public void setNumRegistroMarinha(String numRegistroMarinha) {
        this.numRegistroMarinha = numRegistroMarinha;
    }

    public double getBoca() {
        return boca;
    }

    public void setBoca(double boca) {
        this.boca = boca;
    }

    public double getCaladoAereo() {
        return caladoAereo;
    }

    public void setCaladoAereo(double caladoAereo) {
        this.caladoAereo = caladoAereo;
    }
}
