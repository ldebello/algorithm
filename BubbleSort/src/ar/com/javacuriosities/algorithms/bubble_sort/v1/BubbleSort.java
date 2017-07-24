package ar.com.javacuriosities.algorithms.bubble_sort.v1;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {5, 9, 4, 8, 1, 3};

        int length = data.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (data[j] > data[j+1]) {
                    int aux = data[j];
                    data[j] = data[j+1];
                    data[j+1] = aux;
                }
            }
        }

        System.out.println(Arrays.toString(data));
    }
}
