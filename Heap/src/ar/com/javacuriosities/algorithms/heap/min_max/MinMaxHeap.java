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

    public int removeMin() {
        int minValue = heap[1]; // Se obtiene el mínimo valor
        heap[1] = heap[size--]; // Se asigna el ultimo elemento a la raíz del árbol
        bubbleDownMin(1); // Se re-acomoda el árbol para dejarlo en un estado consistente
        return minValue;
    }

    public int removeMax() {
        // Solo un elemento
        if (size == 1) {
            --size;
            return heap[1];
        }

        // Dos elementos, entonces el maximo es el unico del segundo nivel
        if (size == 2) {
            --size;
            return heap[2];
        }

        // Como mínimo trs elementos, entonces verificamos los hijos
        if (heap[2] > heap[3]) {
            int maxValue = heap[2];
            heap[2] = heap[size--];
            bubbleDownMax(2);
            return maxValue;
        } else {
            int maxValue = heap[3];
            heap[3] = heap[size--];
            bubbleDownMax(3);
            return maxValue;
        }
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

    private void bubbleDownMin(int currentIndex) {
        while (hasChildren(currentIndex)) {
            int minDescIndex = findMinChildGrandchild(currentIndex);
            if (isChild(currentIndex, minDescIndex)) {
                if (heap[minDescIndex] < heap[currentIndex]) {
                    swap(minDescIndex, currentIndex);
                }
                return;
            } else {
                if (heap[minDescIndex] >= heap[currentIndex]) {
                    return;
                }

                swap(minDescIndex, currentIndex);
                int parentIndex = parent(minDescIndex);
                if (heap[minDescIndex] > heap[parentIndex]) {
                    swap(minDescIndex, parentIndex);
                }
                currentIndex = minDescIndex;
            }
        }
    }

    private void bubbleDownMax(int currentIndex) {
        while (hasChildren(currentIndex)) {
            int maxDescIndex = findMaxChildGrandchild(currentIndex);
            if (isChild(currentIndex, maxDescIndex)) {
                if (heap[maxDescIndex] > heap[currentIndex]) {
                    swap(maxDescIndex, currentIndex);
                }
                return;
            } else {
                if (heap[maxDescIndex] <= heap[currentIndex]) {
                    return;
                }

                swap(maxDescIndex, currentIndex);
                int parentIndex = parent(maxDescIndex);
                if (heap[maxDescIndex] < heap[parentIndex])
                    swap(maxDescIndex, parentIndex);
                currentIndex = maxDescIndex;
            }
        }
    }

    private int findMinChildGrandchild(int currentIndex) {
        int leftChildIndex = leftChild(currentIndex);

        int minIndex = leftChildIndex;
        double minValue = heap[leftChildIndex];

        int rightChildIndex = rightChild(currentIndex);
        if (rightChildIndex > size + 1) {
            return minIndex;
        }

        if (heap[rightChildIndex] < heap[leftChildIndex]) {
            minIndex = rightChildIndex;
            minValue = heap[rightChildIndex];
        }

        int grandLeftChildIndexFromLeft = leftChild(leftChildIndex);
        if (grandLeftChildIndexFromLeft > size + 1) {
            return minIndex;
        }

        if (heap[grandLeftChildIndexFromLeft] < minValue) {
            minIndex = grandLeftChildIndexFromLeft;
            minValue = heap[grandLeftChildIndexFromLeft];
        }

        int grandRightChildIndexFromLeft = rightChild(leftChildIndex);
        if (grandRightChildIndexFromLeft > size + 1) {
            return minIndex;
        }

        if (heap[grandRightChildIndexFromLeft] < minValue) {
            minIndex = grandRightChildIndexFromLeft;
            minValue = heap[grandRightChildIndexFromLeft];
        }

        int grandLeftChildIndexFromRight = leftChild(rightChildIndex);
        if (grandLeftChildIndexFromRight > size + 1) {
            return minIndex;
        }

        if (heap[grandLeftChildIndexFromRight] < minValue) {
            minIndex = grandLeftChildIndexFromRight;
            minValue = heap[grandLeftChildIndexFromRight];
        }

        int grandRightChildIndexFromRight = rightChild(rightChildIndex);
        if (grandRightChildIndexFromRight > size + 1) {
            return minIndex;
        }

        return heap[grandRightChildIndexFromRight] < minValue
                ? grandRightChildIndexFromRight
                : minIndex;
    }

    private int findMaxChildGrandchild(int currentIndex) {
        int leftChildIndex = leftChild(currentIndex);

        int maxIndex = leftChildIndex;
        double maxValue = heap[leftChildIndex];

        int rightChildIndex = rightChild(currentIndex);
        if (rightChildIndex > size + 1) {
            return maxIndex;
        }

        if (heap[rightChildIndex] > maxValue) {
            maxIndex = rightChildIndex;
            maxValue = heap[rightChildIndex];
        }

        int grandLeftChildIndexFromLeft = leftChild(leftChildIndex);
        if (grandLeftChildIndexFromLeft > size + 1) {
            return maxIndex;
        }

        if (heap[grandLeftChildIndexFromLeft] > maxValue) {
            maxIndex = grandLeftChildIndexFromLeft;
            maxValue = heap[grandLeftChildIndexFromLeft];
        }

        int grandRightChildIndexFromLeft = rightChild(leftChildIndex);
        if (grandRightChildIndexFromLeft > size + 1) {
            return maxIndex;
        }

        if (heap[grandRightChildIndexFromLeft] > maxValue) {
            maxIndex = grandRightChildIndexFromLeft;
            maxValue = heap[grandRightChildIndexFromLeft];
        }

        int grandLeftChildIndexFromRight = leftChild(rightChildIndex);
        if (grandLeftChildIndexFromRight > size + 1) {
            return maxIndex;
        }

        if (heap[grandLeftChildIndexFromRight] > maxValue) {
            maxIndex = grandLeftChildIndexFromRight;
            maxValue = heap[grandLeftChildIndexFromRight];
        }

        int grandRightChildIndexFromRight = rightChild(rightChildIndex);
        if (grandRightChildIndexFromRight > size + 1) {
            return maxIndex;
        }

        return heap[grandRightChildIndexFromRight] > maxValue
                ? grandRightChildIndexFromRight
                : maxIndex;
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

    private boolean isChild(int currentIndex, int indexToCheck) {
        return indexToCheck <= rightChild(currentIndex);
    }

    private boolean hasChildren(int currentIndex) {
        return currentIndex * 2 <= size;
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

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return (2 * index) + 1;
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