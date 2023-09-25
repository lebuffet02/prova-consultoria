package com.example.demo.desafio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static String getResposta(int x, int y) {
        int z = (x * y) + 5;
        char resposta = (z <= 0) ? 'A' : (z <= 100) ? 'B' : 'C';
        return String.format("Valor de Z: %d Resposta: %c", z, resposta);
    }

    public static void main(String[] args) {
        System.out.println("Digite o valor do X:");
        Scanner scanner = new Scanner(System.in);
        try {
            int x = scanner.nextInt();
            System.out.println("Digite o valor do Y:");
            int y = scanner.nextInt();
            scanner.close();
            System.out.println(getResposta(x, y));
        } catch (InputMismatchException e) {
            System.err.println("Digite apenas números inteiros!");
            System.exit(1);
        }
    }
}
