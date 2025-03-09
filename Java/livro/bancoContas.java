import static java.lang.System.out;
import java.util.Scanner;

class conta{
    /*Definição do que cabe em uma "conta"*/
    private String nome;
    private int codigo;
    private double saldo;
    /*Sets e Gets, captura do que cabe em uma conta*/
    /*Exemplo: Manoel.setNome pega o nome "Manoel" e define como "n", depois esse "n" sera igual a String *privada* nome, assim podendo chegar a ela*/
    /*Depois Manoel.getNome age dentro do Manoel.mostrar quando ele for acionado, retornando nome pra a classe principal*/
    public void setNome(String n){
        nome=n;
    }
    public String getNome(){
        return nome;
    }
    public void setCodigo(int c){
        codigo=c;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setSaldo(double s){
        saldo=s;
    }
    public double getSaldo(){
        return saldo;
    }
    /*O que o código "mostrar" faz*/
    public void mostrar(){
        out.print("A conta de "+getNome()+" ("+getCodigo()+") possui $"+getSaldo()+" ");
    }
    /*O que acontece quando coloca "Nome de uma conta".calcularjuros, ele pega uma taxa definida e faz um calculo depois retorna*/
    public double calcularJuros(double taxa){
        return saldo*taxa/100;
    }
}

class principal{
    public static void main(String args[]){
        try (Scanner teclado = new Scanner(System.in)) {
            /*Criação de new contas baseado em nomes*/
            conta Manoel = new conta(); conta Izabel = new conta(); conta Jaoa = new conta();
            conta André = new conta(); conta Ítalo = new conta(); conta Enzo = new conta();
            /*Define o que cada nome de conta possui (nome codigo saldo)*/
            Manoel.setNome("Manoel"); Manoel.setCodigo(694295); Manoel.setSaldo(7.02); /*Taxa $5*/
            Izabel.setNome("Izabel"); Izabel.setCodigo(379452); Izabel.setSaldo(1054); /*Taxa $2*/
            Jaoa.setNome("Jaoa"); Jaoa.setCodigo(856402); Jaoa.setSaldo(642.50); /*Taxa $7*/
            André.setNome("André"); André.setCodigo(588768); André.setSaldo(193903.67); /*Taxa $4*/
            Ítalo.setNome("Ítalo"); Ítalo.setCodigo(106444); Ítalo.setSaldo(3.50); /*Taxa $8*/
            Enzo.setNome("Enzo"); Enzo.setCodigo(392770); Enzo.setSaldo(142.50); /*Taxa $3*/
            while (true){
                out.println();
                out.print("Insira o código de sua conta: ");
                int insiraCodigo = teclado.nextInt();
                /*Dependendo do código inserido no scanner, o switch ira operar*/
                switch (insiraCodigo){
                    /*Default*/
                    default:
                    out.println();
                    out.println("Código não reconhecido, tente novamente..");
                    break;
                    /*Manoel*/
                    case 694295:
                    double manoelJuros = Manoel.calcularJuros(5);
                    out.println();
                    Manoel.mostrar();
                    out.printf("mais $%.2f de juros",manoelJuros);
                    out.println();
                    break;
                    /*Izabel*/
                    case 379452:
                    double izabelJuros = Izabel.calcularJuros(2);
                    out.println();
                    Izabel.mostrar();
                    out.print("mais $");
                    out.printf("%.2f", izabelJuros);
                    out.print(" de juros");
                    out.println();
                    break;
                    /*Jaoa*/
                    case 856402:
                    double jaoaJuros = Jaoa.calcularJuros(7);
                    out.println();
                    Jaoa.mostrar();
                    out.print("mais $");
                    out.printf("%.2f", jaoaJuros);
                    out.print(" de juros");
                    out.println();
                    break;
                    /*André*/
                    case 588768:
                    double AndréJuros = André.calcularJuros(4);
                    out.println();
                    André.mostrar();
                    out.print("mais $");
                    out.printf("%.2f", AndréJuros);
                    out.print(" de juros");
                    out.println();
                    break;
                    /*Ítalo*/
                    case 106444:
                    double ÍtaloJuros = Ítalo.calcularJuros(8);
                    out.println();
                    Ítalo.mostrar();
                    out.print("mais $");
                    out.printf("%.2f", ÍtaloJuros);
                    out.print(" de juros");
                    out.println();
                    break;
                    /*Enzo*/
                    case 392770:
                    double EnzoJuros = Enzo.calcularJuros(3);
                    out.println();
                    Enzo.mostrar();
                    out.print("mais $");
                    out.printf("%.2f", EnzoJuros);
                    out.print(" de juros");
                    out.println();
                }
            }
        }
    }
}