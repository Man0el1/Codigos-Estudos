
import static java.lang.System.*;

import java.util.Scanner;

public class criarRetangulo {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		out.println();
		out.print("Num de fileiras: ");
		int fileira = teclado.nextInt();
		out.println();
		out.print("Num de colunas: ");
		int coluna = teclado.nextInt();
		out.println();
		out.print("Simbolo pra usar: ");
		String simbolo = teclado.next();
		out.println();

		for (int i = 1; i <= fileira; i++) {
			System.out.println(); /* faz o codigo dar um enter, porem ele so vai dar um enter assim que o... */
			for (int j = 1; j <= coluna; j++) {
				System.out.print(simbolo); /* ...símbolo for repetido na fileira o num de colunas. */
			}
		}
		out.println();
		teclado.close();
	}
}