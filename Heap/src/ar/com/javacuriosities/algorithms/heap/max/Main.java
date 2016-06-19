package ar.com.javacuriosities.algorithms.heap.max;

import ar.com.javacuriosities.algorithms.heap.Heap;

public class Main {
    public static void main(String[] args) {
        Heap maxHeap = new MaxHeap(15);

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        System.out.println("Max Heap");
        System.out.println(maxHeap);
    }
}