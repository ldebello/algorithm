package ar.com.javacuriosities.algorithms.heap.median;

import ar.com.javacuriosities.algorithms.heap.Heap;
import ar.com.javacuriosities.algorithms.heap.min.MinHeap;
import ar.com.javacuriosities.algorithms.heap.max.MaxHeap;

public class MedianHeap implements Heap {

    private MinHeap minHeap;
    private MaxHeap maxHeap;

    public MedianHeap(int maxsize) {
        int size = maxsize / 2 + 2;
        minHeap = new MinHeap(size);
        maxHeap = new MaxHeap(size);
    }

    @Override
    public void insert(int element) {
        if (isEmpty()) {
            minHeap.insert(element);
        } else {
            if (element > median()) {
                minHeap.insert(element);
            } else {
                maxHeap.insert(element);
            }
        }
        balance();
    }

    @Override
    public int size() {
        return minHeap.size() + maxHeap.size();
    }

    public double median() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    private void balance() {
        if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.insert(maxHeap.remove());
            } else {
                maxHeap.insert(minHeap.remove());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Max Heap");
        sb.append("\n");
        sb.append(maxHeap.toString());
        sb.append("Min Heap");
        sb.append("\n");
        sb.append(minHeap.toString());
        return sb.toString();
    }
}