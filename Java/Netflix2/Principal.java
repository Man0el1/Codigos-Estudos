package Netflix2;

import static java.lang.System.*;

import Netflix2.calculos.CalculadoraDeTempo;
import Netflix2.calculos.FiltroRecomendacao;
import Netflix2.modelos.Episodio;
import Netflix2.modelos.Filme;
import Netflix2.modelos.Serie;

public class Principal {

    public static void main(String args[]) {
        // filme
        Filme filme1 = new Filme("O poderoso chefão", 1970, false, 180, "Francis Ford Coppola");
        filme1.avalia(8);
        filme1.avalia(5);
        filme1.avalia(10);
        filme1.avalia(7);
        out.println("média de notas: " + filme1.pegaMedia());
        out.println("Duração em minutos: " + filme1.getDuracaoEmMinutos());
        out.println();
        // serie
        Serie serie1 = new Serie("Lost", 2000, true, 6, false, 10, 30);
        serie1.avalia(10);
        serie1.avalia(5);
        serie1.avalia(8);
        serie1.avalia(9);
        out.println("média de notas: " + serie1.pegaMedia());
        out.println("Temporadas: " + serie1.getTemporadas());
        out.println("Episódios por temporada: " + serie1.getEpisodiosPorTemporada());
        out.println("Duração de episódio: " + serie1.getMinutosPorEpisodio());
        out.println("Duração da série: " + serie1.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.incluir(filme1);
        calculadora.incluir(serie1);
        out.println("Tempo total para maratonar: " + calculadora.getTempoTotal());
        out.println();

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme1);
        Episodio episodio = new Episodio(1, "Piloto", serie1, 300);
        filtro.filtra(episodio);
    }
}
