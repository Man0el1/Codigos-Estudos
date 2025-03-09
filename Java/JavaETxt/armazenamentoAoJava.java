package JavaETxt;

import static java.lang.System.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class empregado {
    private String nome;
    private double saldo;

    public void setNome(String n) {
        nome = n;
    }

    public void setSaldo(double s) {
        saldo = s;
    }

    public void preencherCheque() {
        out.printf("O/A empregado/a *%s* recebeu $%,.2f%n", nome, saldo);
    }
}

class Salário {
    public static void main(String args[]) throws IOException {
        Scanner armazem = new Scanner(
                new File("C:\\Users\\Manoel\\Desktop\\Codigos\\Codigos java\\JavaETxt\\armazenamento.txt"));
        for (int numdoempr = 1; numdoempr <= 2; numdoempr++) {
            pagamento(armazem);
        }
    }

    static void pagamento(Scanner aScanner) {
        empregado umEmpregado = new empregado();
        umEmpregado.setNome(aScanner.nextLine());
        umEmpregado.setSaldo(Double.parseDouble(aScanner.nextLine()));
        umEmpregado.preencherCheque();
    }
}