package ar.com.javacuriosities.algorithms.heap.min_max;

import ar.com.javacuriosities.algorithms.heap.Heap;
import ar.com.javacuriosities.algorithms.heap.max.MaxHeap;
import ar.com.javacuriosities.algorithms.heap.median.MedianHeap;
import ar.com.javacuriosities.algorithms.heap.min.MinHeap;
import ar.com.javacuriosities.algorithms.heap.smm.SMMHeap;

public class Main {
    public static void main(String[] args) {
        MinMaxHeap minMaxHeap = new MinMaxHeap(15);

        minMaxHeap.insert(10);
        minMaxHeap.insert(11);
        minMaxHeap.insert(5);
        minMaxHeap.insert(13);
        minMaxHeap.insert(19);
        minMaxHeap.insert(22);
        minMaxHeap.insert(9);
        minMaxHeap.insert(8);
        minMaxHeap.insert(25);
        minMaxHeap.insert(7);
        minMaxHeap.insert(2);

        System.out.println("MinMax Heap");
        System.out.println(minMaxHeap);

        System.out.println("Delete Min - MinMax Heap");
        minMaxHeap.removeMin();
        System.out.println(minMaxHeap);

        System.out.println("Delete Max - MinMax Heap");
        minMaxHeap.removeMax();
        System.out.println(minMaxHeap);

        System.out.println("Delete Min - MinMax Heap");
        minMaxHeap.removeMin();
        System.out.println(minMaxHeap);
    }
}