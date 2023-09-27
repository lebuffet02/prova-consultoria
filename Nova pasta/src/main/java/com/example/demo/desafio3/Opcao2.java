package com.example.demo.desafio3;


// Escreva um algoritmo que imprima as seguintes sequências de números: (1, 1 2 3 4 5 6 7 8 9 10) (3, 1 2 3 4 5 6 7 8 9 10) (5, 1 2 3 4 5 6 7 8 9 10)
// (7, 1 2 3 4 5 6 7 8 9 10) e assim sucessivamente, até que o primeiro número (antes da vírgula e sempre ímpar), também chegue ao limite de 10.


// Outro modo para resolver o problema especificado:


public class Opcao2 {
    public static void main(String[] args) {
        for (int primeiroNumero = 1; primeiroNumero <= 10; primeiroNumero += 2) {
            System.out.print(primeiroNumero + ", Sequencia Imutável: ");
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

