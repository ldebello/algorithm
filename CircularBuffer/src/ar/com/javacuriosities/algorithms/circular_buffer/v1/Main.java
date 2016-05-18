package ar.com.javacuriosities.algorithms.circular_buffer.v1;

public class Main {
    public static void main(String[] args) {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(Integer.class, 5);

        buffer.enqueue(1);
        buffer.enqueue(3);
        buffer.enqueue(5);

        System.out.println("Buffer Status");
        System.out.println(buffer);

        Integer value = buffer.dequeue();
        System.out.println(value);

        System.out.println("Buffer Status");
        System.out.println(buffer);
    }
}