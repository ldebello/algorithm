package ar.com.javacuriosities.algorithms.bubble_sort.v2;

import java.util.Arrays;

/**
 * Esta implementacion utiliza una variable para controlar si en el inner loop hubo cambios o no,
 * si no fue necesario cambiar nada es que los datos ya se encuentran ordenados.
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {5, 9, 4, 8, 1, 3};

        int length = data.length;
        for (int i = 0; i < length; i++) {
            int exchanges = 0;
            for (int j = length - 1; j > i; j--) {
                if (data[j] < data[j - 1]) {
                    int aux = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = aux;
                    exchanges++;
                }
            }
            if (exchanges == 0) break;
        }

        System.out.println(Arrays.toString(data));
    }
}
