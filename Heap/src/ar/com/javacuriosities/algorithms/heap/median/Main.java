package ar.com.javacuriosities.algorithms.heap.median;

public class Main {
    public static void main(String[] args) {
        MedianHeap medianHeap = new MedianHeap(15);

        medianHeap.insert(1);
        medianHeap.insert(2);
        medianHeap.insert(3);
        medianHeap.insert(4);
        medianHeap.insert(5);

        System.out.println("Median Heap");
        System.out.println(medianHeap);
        System.out.println("Median: " + medianHeap.median());

        medianHeap.insert(5);

        System.out.println(medianHeap);
        System.out.println("Median: " + medianHeap.median());
    }
}