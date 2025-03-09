package Netflix2.modelos;

import Netflix2.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    // nome, anodelançamento, incluso no plano, avaliações, duração em minutos etc
    private String diretor;

    // definição de filme
    public Filme(String nome, int anoDeLancamento, boolean incluidoNoPlano, int duracaoEmMinutos, String diretor) {
        setNome(nome);
        setAnoDeLancamento(anoDeLancamento);
        setIncluidoNoPlano(incluidoNoPlano);
        setDuracaoEmMinutos(duracaoEmMinutos);
        setDiretor(diretor);
        exibeFichaTecnica();
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) (pegaMedia() / 2);
    }
}