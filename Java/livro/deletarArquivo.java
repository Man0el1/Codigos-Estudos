
import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;

class deletarArquivo {
    public static void main(String args[]) {
        File prova = new File("x.txt");
        Scanner teclado = new Scanner(System.in);
        char deletarsn;
        do{
            out.print("Deletar arquivos? (s/n) ");
            deletarsn = teclado.findWithinHorizon(".",0).charAt(0);
        }while (deletarsn != 's' && deletarsn != 'n' && deletarsn != 'S' && deletarsn != 'N');
        if (deletarsn == 's' || deletarsn == 'S'){
            prova.delete();
            out.println("Deletado!");
            teclado.close();
        } else {
            out.println("Ok, ele ainda existe");
            teclado.close();
        }
    }
}
