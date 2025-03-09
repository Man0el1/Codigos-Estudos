package Netflix2.modelos;

import Netflix2.calculos.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private Serie serie;
    private int totalDeVisualizacoes;

    public Episodio(int numero, String nome, Serie serie, int totalDeVisualizacoes){
        setNumero(numero);
        setNome(nome);
        setSerie(serie);
        setTotalDeAvaliacoes(totalDeVisualizacoes);
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getNumero() {
        return numero;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    public Serie getSerie() {
        return serie;
    }
    public void setTotalDeAvaliacoes(int totalDeVisualizacoes) {
        this.totalDeVisualizacoes = totalDeVisualizacoes;
    }
    public int getTotalDeVisualizacoes() {
        return totalDeVisualizacoes;
    }
    
    @Override
    public int getClassificacao() {
        if (totalDeVisualizacoes >= 100){
            return 4;
        } else {
            return 2;
        }
    }
}