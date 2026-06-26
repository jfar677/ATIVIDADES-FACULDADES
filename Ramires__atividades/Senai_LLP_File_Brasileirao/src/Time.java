public class Time implements Comparable<Time> {
    private String nome;
    private int pontos;
    private int golsFeitos;
    private int golsSofridos;

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.golsFeitos = 0;
        this.golsSofridos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public int getGolsFeitos() {
        return golsFeitos;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public int getSaldo() {
        return golsFeitos - golsSofridos;
    }

    public void registrarPartida(int golsMarcados, int golsTomados) {
        this.golsFeitos += golsMarcados;
        this.golsSofridos += golsTomados;
        if (golsMarcados > golsTomados) {
            this.pontos += 3;
        } else if (golsMarcados == golsTomados) {
            this.pontos += 1;
        }
        // Derrota soma 0 pontos
    }

    @Override
    public int compareTo(Time outro) {
        // Ordenação decrescente de pontos
        if (this.pontos != outro.pontos) {
            return Integer.compare(outro.pontos, this.pontos);
        }
        // Critério de desempate: Saldo de gols (decrescente)
        return Integer.compare(outro.getSaldo(), this.getSaldo());
    }
}
