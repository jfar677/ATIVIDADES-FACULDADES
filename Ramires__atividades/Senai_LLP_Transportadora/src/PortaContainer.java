public class PortaContainer extends VeiculoFluvial {
    private int capacidadeCargaTeu;
    private String categoria;

    public PortaContainer(int anoFabricacao, String marca, String modelo, String propulsao,
                          String numRegistroMarinha, double boca, double caladoAereo,
                          int capacidadeCargaTeu, String categoria) {
        super(anoFabricacao, marca, modelo, propulsao, numRegistroMarinha, boca, caladoAereo);
        this.capacidadeCargaTeu = capacidadeCargaTeu;
        this.categoria = categoria;
    }

    public int getCapacidadeCargaTeu() {
        return capacidadeCargaTeu;
    }

    public void setCapacidadeCargaTeu(int capacidadeCargaTeu) {
        this.capacidadeCargaTeu = capacidadeCargaTeu;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public double calcularFrete(double peso, double altura, double largura, double distancia) {
        return (peso + (altura * largura)) * distancia;
    }
}
