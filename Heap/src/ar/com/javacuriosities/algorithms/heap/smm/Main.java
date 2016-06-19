package ar.com.javacuriosities.algorithms.heap.smm;

import ar.com.javacuriosities.algorithms.heap.Heap;

public class Main {
    public static void main(String[] args) {
        Heap symmetricMinMaxHeap = new SMMHeap(15);

        symmetricMinMaxHeap.insert(2);
        symmetricMinMaxHeap.insert(72);
        symmetricMinMaxHeap.insert(9);
        symmetricMinMaxHeap.insert(3);
        symmetricMinMaxHeap.insert(57);
        symmetricMinMaxHeap.insert(68);
        symmetricMinMaxHeap.insert(13);
        symmetricMinMaxHeap.insert(32);
        symmetricMinMaxHeap.insert(7);
        symmetricMinMaxHeap.insert(12);
        symmetricMinMaxHeap.insert(49);
        symmetricMinMaxHeap.insert(37);

        System.out.println("Symmetric Min-Max Heap");
        System.out.println(symmetricMinMaxHeap);
    }
}