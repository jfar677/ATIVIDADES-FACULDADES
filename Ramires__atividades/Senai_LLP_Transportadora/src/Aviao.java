public class Aviao extends VeiculoAereo {
    private double capacidadeCarga;
    private double volumePesoMaximoDecolagem; // MTOW

    public Aviao(int anoFabricacao, String marca, String modelo, String propulsao,
                 String registroAeronauticoBrasileiro, int qtdeMotores,
                 double capacidadeCarga, double volumePesoMaximoDecolagem) {
        super(anoFabricacao, marca, modelo, propulsao, registroAeronauticoBrasileiro, qtdeMotores);
        this.capacidadeCarga = capacidadeCarga;
        this.volumePesoMaximoDecolagem = volumePesoMaximoDecolagem;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getVolumePesoMaximoDecolagem() {
        return volumePesoMaximoDecolagem;
    }

    public void setVolumePesoMaximoDecolagem(double volumePesoMaximoDecolagem) {
        this.volumePesoMaximoDecolagem = volumePesoMaximoDecolagem;
    }

    @Override
    public double calcularFrete(double peso, double altura, double largura, double distancia) {
        return ((peso * peso) * (altura * largura)) * (distancia * 9.99);
    }
}
