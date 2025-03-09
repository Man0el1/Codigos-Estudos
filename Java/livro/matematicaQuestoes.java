
import static java.lang.System.*;

public class matematicaQuestoes {
    public static void main(String args[]) {
        double a = 1;
        double b = 1;
        double c;
        double d = 0;
        while ((a <= 99) && (b <= 50)) {
            c = 0;
            c = a / b;
            d += c;
            a += 2;
            b++;
        }
        out.printf("%.2f", d);
        out.println();
        out.println();

        a = 2;
        b = 1;
        c = 50;
        double e = 0;
        while ((c >= 1) && (b <= 50)) {
            d = 0;
            d = Math.pow(a, b) / c;
            e += d;
            c--;
            b++;
        }
        out.printf("%.2f", e);
        out.println();
        out.println();

        a = 1;
        b = Math.pow(a, 2);
        d = 0;
        while ((a <= 10) && (b <= 100)) {
            c = 0;
            b = Math.pow(a, 2);
            c = a / b;
            if (a % 2 == 0) {
                d += c;
            } else {
                d -= c;
            }
            a++;
        }
        out.printf("%.2f", d);
        out.println();
        out.println();

        int abcd = 1000;
        int ab = 10;
        int cd = 00;
        for (abcd = 1000; abcd <= 9999; ab++) {
            while (cd <= 99) {
                int ef = ab + cd;
                if (abcd == ef * ef) {
                    out.printf("%d+%d=%d^2=%d\n\n", ab, cd, ab + cd, abcd);
                }
                cd++;
                abcd++;
            }
            cd = 0;
        }
    }
}
