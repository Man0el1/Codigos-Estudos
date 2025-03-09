package Netflix2.calculos;

import static java.lang.System.out;

public class FiltroRecomendacao {
    
    public void filtra(Classificavel classificavel){
        if(classificavel.getClassificacao() >= 4){
            out.println("Está entre um dos mais bem avaliados");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}