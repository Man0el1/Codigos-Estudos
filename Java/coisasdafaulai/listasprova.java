import java.util.ArrayList;
import java.util.Scanner;

public class listasprova {
    public static void main(String[] args) throws InterruptedException {
        final int TAMANHO_DA_LISTA = 8;
        ArrayList<Integer> lista = new ArrayList<>(TAMANHO_DA_LISTA);
        for (int numeroAdicionarLista = 0; numeroAdicionarLista < TAMANHO_DA_LISTA; numeroAdicionarLista++) {
            lista.add(numeroAdicionarLista * 2);
        }
        System.out.println(lista + "\n");
        boolean numeroFoiEncontrado = false;
        int listaInicio = 0;
        int listaMeio = 0;
        int listaFinal = TAMANHO_DA_LISTA - 1;

        Scanner sc = new Scanner(System.in);
        System.out.print("Deseja procurar que numero: ");
        int NumeroASerProcurado = sc.nextInt();

        while (listaInicio <= listaFinal && !numeroFoiEncontrado) {
            listaMeio = (int) ((listaInicio + listaFinal) / 2);
            System.out.println(listaMeio);
            Thread.sleep(1000);
            if (lista.get(listaMeio) == NumeroASerProcurado) {
                numeroFoiEncontrado = true;
            } else if (lista.get(listaMeio) < NumeroASerProcurado) {
                listaInicio = listaMeio;
            } else if (lista.get(listaMeio) > NumeroASerProcurado) {
                listaFinal = listaMeio;
            }
        }
        System.out.printf("Numero %d encontrado no indice %d do array\n", NumeroASerProcurado, listaMeio);
        sc.close();
    }
}
