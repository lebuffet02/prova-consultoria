package com.example.demo.desafio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int getSomarIdades(int homemUm, int homemDois, int mulherUm, int mulherDois) {
        int homemMaisVelho = Math.max(homemUm, homemDois);
        int mulherMaisNova = Math.min(mulherUm, mulherDois);
        return homemMaisVelho + mulherMaisNova;
    }

    public static int getMultiplicarIdades(int homemUm, int homemDois, int mulherUm, int mulherDois) {
        int homemMaisNovo = Math.min(homemUm, homemDois);
        int mulherMaisVelha = Math.max(mulherUm, mulherDois);
        return homemMaisNovo * mulherMaisVelha;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int homemUm;
        int homemDois;
        int mulherUm;
        int mulherDois;
        try {
            System.out.print("Digite a idade do primeiro homem: ");
            homemUm = scanner.nextInt();
            System.out.print("Digite a idade do segundo homem: ");
            homemDois = scanner.nextInt();
            System.out.print("Digite a idade da primeira mulher: ");
            mulherUm = scanner.nextInt();
            System.out.print("Digite a idade da segunda mulher: ");
            mulherDois = scanner.nextInt();
            scanner.close();
            System.out.println("Somar as Idades: "+ getSomarIdades(homemUm, homemDois, mulherUm, mulherDois));
            System.out.println("Multiplicar as Idades: " + getMultiplicarIdades(homemUm, homemDois, mulherUm, mulherDois));
        } catch (InputMismatchException e) {
            System.err.println("Digite apenas números inteiros");
            System.exit(1);
        }
    }
}
