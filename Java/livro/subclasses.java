import static java.lang.System.out;

//Classe empregado
class empregado {
    private String nome;
    private String cargo;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }
    public void preencherCheque(double valorPago) {
        out.printf("*%s* (%s) recebeu $%,.2f%n", nome, cargo, valorPago);
    }
}
//Classe empregado -> empregadoPeríodoIntegral
class empregadoPeríodoIntegral extends empregado{
    private double salárioSemanal;
    private double deduçãoDeBenefícios;
    public void setsalárioSemanal(Double salárioSemanal) {
        this.salárioSemanal = salárioSemanal;
    }
    public double getSalárioSemanal() {
        return salárioSemanal;
    }
    public void setDeduçãoDeBenefícios(Double deduçãoDeBenefícios) {
        this.deduçãoDeBenefícios = deduçãoDeBenefícios;
    }
    public double getDeduçãoDeBenefícios() {
        return deduçãoDeBenefícios;
    }
    public double cálculoDoPagamento(){
        return salárioSemanal - deduçãoDeBenefícios;
    }
}
//Classe empregado -> empregadoMeioPeríodo
class empregadoMeioPeríodo extends empregado{
    private double taxaPorHora;
    public void setTaxaPorHora(Double taxaPorHora) {
        this.taxaPorHora = taxaPorHora;
    }
    public double getTaxaPorHora() {
        return taxaPorHora;
    }
    public double cálculoDoPagamento(int horas){
        return taxaPorHora*horas;
    }
}
//Classe empregado -> empregadoMeioPeríodo -> MeioPeríodoHorasEmDobro
//Após 40 horas de trabalho, o ganho por hora duplica 
class MeioPeríodoHorasEmDobro extends empregadoMeioPeríodo{
    @Override public double cálculoDoPagamento(int horas){
        if (horas <=40){
            return getTaxaPorHora() * horas;
        }else{
            return getTaxaPorHora() * 40 + getTaxaPorHora() * 2 * (horas-40);
        }
    }
}
public class subclasses {
    public static void main(String args[]){
        empregadoPeríodoIntegral xempregado = new empregadoPeríodoIntegral();
        xempregado.setNome("Manoel");
        xempregado.setCargo("CEO");
        xempregado.setsalárioSemanal(5000.00);
        xempregado.setDeduçãoDeBenefícios(500.00);
        xempregado.preencherCheque(xempregado.cálculoDoPagamento());
        out.println();
        empregadoMeioPeríodo yempregado = new empregadoMeioPeríodo();
        yempregado.setNome("Izabel");
        yempregado.setCargo("Designer");
        yempregado.setTaxaPorHora(150.00);
        yempregado.preencherCheque(yempregado.cálculoDoPagamento(29));
        out.println();
        empregadoMeioPeríodo zempregado = new empregadoMeioPeríodo();
        zempregado.setNome("Ítalo");
        zempregado.setCargo("Gerente");
        zempregado.setTaxaPorHora(90.00);
        zempregado.preencherCheque(zempregado.cálculoDoPagamento(46));
    }
}
