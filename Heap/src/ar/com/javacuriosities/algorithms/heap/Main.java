package ar.com.javacuriosities.algorithms.heap;

public class Main {
    public static void main(String[] args) {
        Heap minHeap = new MinHeap(15);
        Heap maxHeap = new MaxHeap(15);
        Heap symmetricMinMaxHeap = new SMMHeap(15);
        MedianHeap medianHeap = new MedianHeap(15);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

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

        medianHeap.insert(1);
        medianHeap.insert(2);
        medianHeap.insert(3);
        medianHeap.insert(4);
        medianHeap.insert(5);

        System.out.println("Min Heap");
        System.out.println(minHeap);

        System.out.println("Max Heap");
        System.out.println(maxHeap);

        System.out.println("Symmetric Min-Max Heap");
        System.out.println(symmetricMinMaxHeap);

        System.out.println("Median Heap");
        System.out.println(medianHeap);
        System.out.println(medianHeap.median());
    }
}