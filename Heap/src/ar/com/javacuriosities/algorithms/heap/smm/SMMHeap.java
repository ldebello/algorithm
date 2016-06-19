package ar.com.javacuriosities.algorithms.heap.smm;

import ar.com.javacuriosities.algorithms.heap.Heap;

/*
 * Esta implementación es One-Based index
 */
public class SMMHeap implements Heap {

    private int[] heap;
    private int size = 1;

    public SMMHeap(int maxSize) {
        heap = new int[maxSize];
    }

    @Override
    public void insert(int element) {
        size++; // Incrementamos el size
        heap[size] = element; // Agregamos el elemento al final del arreglo
        if (isInMinHeap(size)) {
            insertMin(size);
        } else {
            insertMax(size);
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void insertMin(int currentIndex) {
        while (parent(currentIndex) > 1 && heap[currentIndex] < heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    private void insertMax(int currentIndex) {
        while (parent(currentIndex) > 1 && heap[currentIndex] > heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    private void swap(int from, int to) {
        int tmp;
        tmp = heap[from];
        heap[from] = heap[to];
        heap[to] = tmp;
    }

    private boolean isInMinHeap(int index) {
        while (index > 3) {
            index /= 2;
        }
        return index == 2;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int height() {
        return (int) Math.ceil(Math.log((size + 1) - 1) / Math.log(2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int maxElementsByLevel = 2;
        int numberOfElements = 0;

        int height = height() - 1;
        int gap = (int) Math.pow(2, height);

        for (int i = 2; i <= size; i++) {
            for (int j = 0; j < gap - 1; j++) {
                sb.append(" ");
            }
            if (numberOfElements != 0) {
                for (int j = 0; j < gap - 1; j++) {
                    sb.append(" ");
                }
            }
            if (Integer.toString(heap[i]).length() == 1) {
                sb.append(" ");
            }
            sb.append(heap[i]);

            numberOfElements++;
            if (numberOfElements == maxElementsByLevel) {
                sb.append("\n");
                numberOfElements = 0;
                maxElementsByLevel *= 2;
                gap /= 2;
            }
        }
        sb.append("\n");
        return sb.toString();
    }
}