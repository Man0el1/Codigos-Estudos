
import static java.lang.System.out;
import java.util.Scanner;

public class raizQuadrada {
    public static void main(String[] args){
        double x = 10;
        double y = -5.37;

        out.println("Max"); /*maior num*/
        out.println(Math.max(x, y));

        out.println("Min"); /*menor num*/
        out.println(Math.min(x, y));

        out.println("Abs"); /*num sem o negativo*/
        out.println("-5.37 -> " + Math.abs(y));

        out.println("Sqrt"); /*square root/raiz quadrada*/
        out.println("10 -> " + Math.sqrt(x));

        out.println("Round"); /*Arredondar*/
        out.println("-5.37 -> " + Math.round(y));

        /*Math.pow(x, y) é a potencia de um numero, x elevado a y*/

        double a;
        double b;

        Scanner teclado = new Scanner(System.in);
        out.println("Cálculo da hipotenusa");
        out.print("Insira X: ");
        a = teclado.nextDouble();
        out.print("Insira Y: ");
        b = teclado.nextDouble();
        out.println("A hipotenusa de "+ a +" e "+ b +" é "+ Math.sqrt((a*a)+(b*b)));
        teclado.close();
    }
}
