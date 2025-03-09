
import static java.lang.System.out;

enum tempEscala{
    Celsius,Fahrenheit,Kelvin
}
class temperatura{
    private double numero;
    private tempEscala escala;
    public temperatura(){
        numero=0.0;
        escala=tempEscala.Celsius;
    }
    public temperatura(double numero){
        this.numero=numero;
        escala=tempEscala.Celsius;
    }
    public temperatura(tempEscala escala){
        numero=0.0;
        this.escala=escala;
    }
    public temperatura(double numero,tempEscala escala){
        this.numero=numero;
        this.escala=escala;
        
    }
    public void setNumero(double numero){
        this.numero = numero;
    }
    public double getNumero(){
        return numero;
    }
    public void setEscala(tempEscala escala){
        this.escala = escala;
    }
    public tempEscala getEscala(){
        return escala;
    }

}

public class enumTemperatura {
    public static void main(String args[]){
        temperatura temp = new temperatura();
        temp.setNumero(30.0);
        temp.setEscala(tempEscala.Celsius);
        out.printf("São %.1f graus %s\n", temp.getNumero(),temp.getEscala());
    }
}
