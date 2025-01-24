package com.playground;

import java.util.*;

import static java.util.Collections.*;

public class Dummy {

    public static void main(String[] args) {
        int[] numeros = {2, 3, 2, 3, 3, 4, 4, 4, 4, 5, 5}; // Ejemplo de arreglo
        int numeroImparFrecuencia = encontrarNumeroConFrecuenciaImpar(numeros);

        if (numeroImparFrecuencia != -1) {
            System.out.println("El número que aparece un número impar de veces es: " + numeroImparFrecuencia);
        } else {
            System.out.println("No se encontró ningún número con una frecuencia impar.");
        }
    }

    public static int encontrarNumeroConFrecuenciaImpar(int[] numeros) {
        Map<Integer, Integer> frecuenciaMap = new HashMap<>();

        // Contar las apariciones de cada número
        for (int numero : numeros) {
            frecuenciaMap.put(numero, frecuenciaMap.getOrDefault(numero, 0) + 1);
        }

        // Buscar el primer número con una frecuencia impar
        for (Map.Entry<Integer, Integer> entrada : frecuenciaMap.entrySet()) {
            if (entrada.getValue() % 2 != 0) {
                return entrada.getKey();
            }
        }

        return -1; // Si no se encuentra ningún número con una frecuencia impar
    }

}
