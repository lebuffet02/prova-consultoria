package com.example.demo.desafio3;

import org.javatuples.Pair;

public class Main {

    private static final String SEQUENCIA_IMUTAVEL = "1 2 3 4 5 6 7 8 9 10";

    public static void main(String[] args) {
        int numeroImpar = 1;
        for (int i = 0; i < 10; i++) {
            if(numeroImpar < 10) {
                Pair<Integer, String> pair = new Pair<>(numeroImpar, String.format("Sequencia Imutável: ".concat(SEQUENCIA_IMUTAVEL)));
                numeroImpar += 2;
                System.out.println(pair.getValue0() + ", " + pair.getValue1());
            }
        }
    }
}
