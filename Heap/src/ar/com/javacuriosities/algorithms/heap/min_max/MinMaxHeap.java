package ar.com.javacuriosities.algorithms.heap.min_max;

import ar.com.javacuriosities.algorithms.heap.Heap;

/*
 * Esta implementación es One-Based index
 */
public class MinMaxHeap implements Heap {

    private int size;
    private int[] heap;

    public MinMaxHeap(int maxsize) {
        this.size = 0;
        heap = new int[maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    @Override
    public void insert(int element) {
        size++; // Incrementamos el size
        heap[size] = element; // Agregamos el elemento al final del arreglo
        bubbleUp(size);
    }

    private void bubbleUp(int currentIndex) {
        boolean isMinLevel = isInMinLevel(currentIndex);
        int parentIndex = parent(currentIndex);
        if (parentIndex > 0) {
            if (isMinLevel) {
                if (heap[currentIndex] > heap[parentIndex]) {
                    swap(currentIndex, parentIndex);
                    bubbleUpMax(parentIndex);
                } else {
                    bubbleUpMin(currentIndex);
                }
            } else {
                if (heap[currentIndex] < heap[parentIndex]) {
                    swap(currentIndex, parentIndex);
                    bubbleUpMin(parentIndex);
                } else {
                    bubbleUpMax(currentIndex);
                }
            }
        }

    }

    private void swap(int from, int to) {
        int tmp;
        tmp = heap[from];
        heap[from] = heap[to];
        heap[to] = tmp;
    }

    private void bubbleUpMin(int currentIndex) {
        int grandParent = grandParent(currentIndex);
        if (grandParent > 0) {
            if (heap[currentIndex] < heap[grandParent]) {
                swap(currentIndex, grandParent);
                bubbleUp(grandParent);
            }
        }
    }

    private void bubbleUpMax(int currentIndex) {
        int grandParent = grandParent(currentIndex);
        if (grandParent > 0) {
            if (heap[currentIndex] > heap[grandParent]) {
                swap(currentIndex, grandParent);
                bubbleUp(grandParent);
            }
        }
    }

    private boolean isInMinLevel(int currentIndex) {
        return (int) (Math.log(currentIndex) / Math.log(2)) % 2 == 0;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int grandParent(int index) {
        return index / 4;
    }

    @Override
    public int size() {
        return size;
    }

    private int height() {
        return (int) Math.ceil(Math.log((size + 1) - 1) / Math.log(2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int maxElementsByLevel = 1;
        int numberOfElements = 0;

        int height = height();
        int gap = (int) Math.pow(2, height);

        for (int i = 1; i <= size; i++) {
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