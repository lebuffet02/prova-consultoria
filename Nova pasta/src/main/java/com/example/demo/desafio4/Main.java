package com.example.demo.desafio4;

import java.util.Arrays;

public class Main {

    public static int[] getJuntaArrays(int[] arrayUm, int[] arrayDois) {
        int[] ret = new int[arrayUm.length + arrayDois.length];
        System.arraycopy(arrayUm, 0, ret, 0, arrayUm.length);
        System.arraycopy(arrayDois, 0, ret, arrayUm.length, arrayDois.length);
        return ret;
    }

    public static int[] getOrdenaArraysAgrupados(int[] arrayUm, int[] arrayDois) {
        int[] array = getJuntaArrays(arrayUm, arrayDois);
        return getOrdena(array);
    }

    private static int[] getOrdena(int[] arrayEntrada) {
        for(int i = 0; i < arrayEntrada.length-1; i++) {
            for(int j = 0; j < arrayEntrada.length-1-i; j++) {
                if (arrayEntrada[j] > arrayEntrada[j + 1]) {
                    int aux = arrayEntrada[j];
                    arrayEntrada[j] = arrayEntrada[j + 1];
                    arrayEntrada[j + 1] = aux;
                }
            }
        }
        return arrayEntrada;
    }

    public static void main(String[] args) {
        int[] arrayUm = {0, 221, 331, 441, 551};
        int[] arrayDois = {1, 2, 3, 4, 5};
        System.out.printf(Arrays.toString(getOrdenaArraysAgrupados(arrayUm, arrayDois)));
    }
}
