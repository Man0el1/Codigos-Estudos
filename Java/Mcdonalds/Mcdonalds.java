package Mcdonalds;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Alimento {
    private String nome;
    private int calorias;
    private Double preço;

    public Alimento(String nome, int calorias, double preço) {
        this.nome = nome;
        this.calorias = calorias;
        this.preço = preço;
    }

    public String getNome() {
        return nome;
    }

    public int getCalorias() {
        return calorias;
    }

    public double getPreço() {
        return preço;
    }

    public String getCaloriasString() {
        DecimalFormat caloriasDec = new DecimalFormat();
        return caloriasDec.format(calorias);
    }

    public String getPreçoString() {
        DecimalFormat preçoDec = new DecimalFormat();
        preçoDec.setMaximumFractionDigits(2);
        preçoDec.setMinimumFractionDigits(2);
        return preçoDec.format(preço);
    }
}

class frameDoMenu extends JFrame {
    public frameDoMenu() throws IOException {
        Alimento alimento;
        try (Scanner teclado = new Scanner(
                new File("./menuMc.txt"))) {
            for (int x = 1; x <= 13; x++) {
                alimento = new Alimento(teclado.nextLine(), Integer.parseInt(teclado.nextLine()),
                        Double.parseDouble(teclado.nextLine()));
                addAlimentoInfo(alimento);
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setTitle("Menu do Mcdonalds");
        setLayout(new GridLayout(13, 0, 20, 10));
        setLocation(700, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    void addAlimentoInfo(Alimento alimento) {
        add(new JLabel(alimento.getNome()));
        add(new JLabel(alimento.getCaloriasString() + "kcal"));
        add(new JLabel("R$" + alimento.getPreçoString()));
    }
}

class mostrarFrame {
    public static void main(String args[]) throws IOException {
        new frameDoMenu();
    }
}