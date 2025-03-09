
import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

class Testedescanner{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int numaleatorio = new Random().nextInt(10) + 1;
        int numdepalpites = 1;
        int rodada = 1;
        
        out.println();
        out.println("         ***************         ");
        out.println(" Bem vindo ao jogo de adivinhação");
        out.println("         ***************         ");
        out.println();
        while (true){
            out.print("Escolha um numero entre 1 a 10: ");
            int numadivinhado = teclado.nextInt();
        
            while (numadivinhado != numaleatorio){
                out.println();
                out.println("Nope, tente novamente");
                out.print("Escolha um numero entre 1 a 10: ");
                numaleatorio = new Random().nextInt(10) + 1;
                numdepalpites++;
                numadivinhado = teclado.nextInt();
            }

            out.println();
            out.println("Você venceu!");
            if (numdepalpites == 1) {
                out.println("E levou apenas 1 tentativa, de primeira!");
            } else {
                out.println("E levou apenas " + numdepalpites + " tentativas");
            }
            numdepalpites = 1;
            int simounao;
            do{
                out.println("Quer jogar de novo? 1-Sim 2-Não");
                simounao = teclado.nextInt();
            }while (simounao != 1 && simounao != 2);
            switch (simounao){
            case 1:
                numaleatorio = new Random().nextInt(10) + 1;
                out.println("Vamos continuar...");
                out.println();
                rodada++;
                out.println("Rodada " + rodada + "!");
                continue;
            case 2:
                out.println();
                out.println("Obrigado por jogar! Até a proxima!");
                out.println();
                teclado.close();
                break;
            }
        break;
        }
    }
}