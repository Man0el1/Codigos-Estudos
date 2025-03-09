package Netflix2.modelos;

public class Serie extends Titulo { // nome, anodelançamento, incluso no plano, avaliações, duração em minutos etc
    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    // definição de série
    public Serie(String nome, int anoDeLancamento, boolean incluidoNoPlano, int temporadas, boolean ativa,
            int episodiosPorTemporada, int minutosPorEpisodio) {
        setNome(nome);
        setAnoDeLancamento(anoDeLancamento);
        setIncluidoNoPlano(incluidoNoPlano);
        setTemporadas(temporadas);
        setAtiva(ativa);
        setEpisodiosPorTemporada(episodiosPorTemporada);
        setMinutosPorEpisodio(minutosPorEpisodio);
        exibeFichaTecnica();
    }

    // sets e gets
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }
}
