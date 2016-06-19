package ar.com.javacuriosities.algorithms.heap.max;

import ar.com.javacuriosities.algorithms.heap.Heap;

/*
 * Esta implementación es One-Based index
 */
public class MaxHeap implements Heap {

    private int size;
    private int[] heap;

    public MaxHeap(int maxsize) {
        this.size = 0;
        heap = new int[maxsize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    @Override
    public void insert(int element) {
        size++; // Incrementamos el size
        heap[size] = element; // Agregamos el elemento al final del arreglo
        bubbleUp(size);
    }

    @Override
    public int size() {
        return size;
    }

    public int peek() {
        return heap[1];
    }

    public int remove() {
        int maxValue = heap[1]; // Se obtiene el maximo valor
        heap[1] = heap[size--]; // Se asigna el ultimo elemento a la raíz del árbol
        bubbleDown(1); // Se re-acomoda el árbol para dejarlo en un estado consistente
        return maxValue;
    }

    private void bubbleUp(int currentIndex) {
        while (heap[currentIndex] > heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    private void bubbleDown(int index) {
        if (!isLeaf(index)) {
            if (heap[index] < heap[leftChild(index)] || heap[index] < heap[rightChild(index)]) {
                if (heap[leftChild(index)] > heap[rightChild(index)]) {
                    swap(index, leftChild(index));
                    bubbleDown(leftChild(index));
                } else {
                    swap(index, rightChild(index));
                    bubbleDown(rightChild(index));
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

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return (2 * index);
    }

    private int rightChild(int index) {
        return (2 * index) + 1;
    }

    private boolean isLeaf(int index) {
        return leftChild(index) > size;
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