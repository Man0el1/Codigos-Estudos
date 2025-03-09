package Netflix2.calculos;

import Netflix2.modelos.Titulo;

import static java.lang.System.out;

public class CalculadoraDeTempo {

    private int tempoTotal;

/*  public void incluir(Filme filme){
        this.tempoTotal += filme.getDuracaoEmMinutos();
    }
    public void incluir(Serie serie){
        this.tempoTotal += serie.getDuracaoEmMinutos();
    }*/
    public void incluir(Titulo titulo){
        out.println("Adicionando duração em minutos de " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }

    public int getTempoTotal() {
        return tempoTotal;
    }
}