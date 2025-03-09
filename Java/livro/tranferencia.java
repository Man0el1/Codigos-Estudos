import static java.lang.System.*;
import java.util.Scanner;

public class tranferencia {
    public static void main(String args[]){

        class conta{
            private String nome;
            private double saldo;
            public void setNome(String nome) {
                this.nome = nome;
            }
            public void setSaldo(double saldo) {
                this.saldo = saldo;
            }
            public String getNome() {
                return nome;
            }
            public double getSaldo() {
                return saldo;
            }
            public void mostrarOpcoes() {
                out.println();
                out.println("Operações");
                out.println();
                out.println("1- Consultar saldos");
                out.println("2- Receber valor");
                out.println("3- Transferir valor");
                out.println("4- Sair");
                out.println();
                out.print("Digite a opção desejada: ");
            }
            public void mostrarConta() {
                out.println();
                out.println("***********************");
                out.println("Dados iniciais do cliente:");
                out.println();
                out.println("Nome: Izabel Gomes");
                out.println("Tipo conta: Corrente");
                out.println("Saldo inicial: R$ 2500,00");
                out.println("***********************");
            }
        }

        boolean x=true;
        int opcao;
        double adicionarSaldo = 0;
        double removerSaldo = 0;
        Scanner teclado = new Scanner(in);
        conta izabel = new conta();
        
        izabel.setNome("Izabel Gomes"); izabel.setSaldo(2500.00);
        out.println();
        out.printf("Bem vindo %s",izabel.getNome());
        out.println();
        
        while(x){
            izabel.mostrarOpcoes();
            opcao = teclado.nextInt();

            switch (opcao){
                case 1:
                izabel.mostrarConta();
                break;
                case 2:
                out.println();
                out.print("Informe o valor a receber: ");
                adicionarSaldo = teclado.nextDouble();
                izabel.setSaldo(izabel.getSaldo()+adicionarSaldo);
                out.println();
                out.printf("Saldo atualizado: %f",izabel.getSaldo());
                out.println();
                break;
                case 3:
                out.println();
                out.print("Informe o valor a trasferir: ");
                removerSaldo = teclado.nextDouble();
                izabel.setSaldo(izabel.getSaldo()-removerSaldo);
                out.println();
                out.printf("Saldo atualizado: %f",izabel.getSaldo());
                out.println();
                break;
                case 4:
                x=false;
                teclado.close();
                break;
                default:
                out.println();
                out.println("informe um numero válido");
                out.println();
            }
        }
    }

}
