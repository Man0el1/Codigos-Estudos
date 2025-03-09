package HotelJava;

import static java.lang.System.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class hotel2 {
    public static void main(String args[]) throws IOException {
        try (// Scanners e ints, for define que os numeros do txt são numQuartos e armazenam
             // hospedes
                Scanner armazem = new Scanner(
                        new File("C:\\Users\\LENOVO\\Desktop\\Codigos\\Codigos java\\HotelJava\\quartos2.txt"))) {
            try (Scanner teclado = new Scanner(System.in)) {
                int hospedes[] = new int[10];
                int numQuarto;
                for (numQuarto = 0; numQuarto < hospedes.length; numQuarto++) {
                    hospedes[numQuarto] = armazem.nextInt();
                }
                out.println();
                out.println("Seja bem vindo ao Hotel Java!");
                // Começo do loop
                while (true) {
                    out.println();
                    out.println("Deseja fazer check-in ou check-out?");
                    out.print("1-Check-in 2-Check-out 3-Conferir quartos ");
                    int opcao = teclado.nextInt();
                    // *********check-in*********
                    if (opcao == 1) {
                        numQuarto = 0;
                        while (numQuarto < hospedes.length && hospedes[numQuarto] != 0) {
                            numQuarto++;
                        }
                        if (numQuarto == hospedes.length) {
                            out.println();
                            out.println("Desculpe, não há vagas, esperando check-out");
                        } else {
                            out.println(); // %s String no placeholder||%d indica um valor inteiro||%f indica um valor
                                           // decimal \t = espaçamento
                            out.printf("Quantos hóspedes iram se ocupar no quarto %d? ", numQuarto);
                            hospedes[numQuarto] = teclado.nextInt();
                            try (PrintStream listout = new PrintStream(
                                    "C:\\Users\\LENOVO\\Desktop\\Codigos\\Codigos java\\HotelJava\\quartos2.txt")) {
                                for (numQuarto = 0; numQuarto < hospedes.length; numQuarto++) {
                                    listout.print(hospedes[numQuarto] + " ");
                                }
                            }
                            out.println("Check-in feito!");
                        }
                        // *********check-out*********
                    } else if (opcao == 2) {
                        out.println();
                        out.print("De qual quarto deseja fazer checkout? ");
                        int x = teclado.nextInt();
                        if (hospedes[x] == 0) {
                            out.println("O quarto selecionado já está vazio");
                        } else {
                            hospedes[x] = 0;
                            try (PrintStream listout = new PrintStream(
                                    "C:\\Users\\LENOVO\\Desktop\\Codigos\\Codigos java\\HotelJava\\quartos2.txt")) {
                                for (numQuarto = 0; numQuarto < hospedes.length; numQuarto++) {
                                    listout.print(hospedes[numQuarto] + " ");
                                }
                            }
                            out.println("Check-out feito!");
                        }
                        // *********conferir quartos*********
                    } else if (opcao == 3) {
                        for (numQuarto = 0; numQuarto < hospedes.length; numQuarto++) {
                            out.printf("Quarto %d: %s \t ", numQuarto, hospedes[numQuarto]);
                        }
                        out.println();
                    } else if (opcao == 69) {
                        out.println();
                        out.println("nice");
                        // *********erro*********
                    } else {
                        out.println();
                        out.println("Digite um dos números disponíveis");
                    }
                }
            }
        }
    }
}
