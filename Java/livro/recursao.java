import java.util.Scanner;

public class recursao {
    public static int fatorizar(int num) {
        if (num == 1) {
            System.out.print("1 = ");
            return 1;
        }
        System.out.printf("%d * ", num);
        return num * fatorizar(num - 1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.print("Insira um numero para fatoriar (0 para cancelar): ");
            num = sc.nextInt();
            if (num == 0) {
                break;
            }
            int resultado = fatorizar(num);
            System.out.printf("%d\n\n", resultado);
        } while (num != 0);
        sc.close();
    }
}
