package ar.com.javacuriosities.algorithms.circular_buffer.v1;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * Un buffer circular es una estructura la cual permite un comportamiento
 * del tipo FIFO (First In - First Out) y tiene la ventaja de que la información
 * esta contigua en la memoria ya que esta guardada en un array.
 *
 * La estructura puede ser implementada con dos punteros, uno para la escritura y otro lectura
 * o solo con el de escritura y una variable con la cantidad de ejemplos
 *
 * [2] [3] [ ] [ ] [ ] [ ] [0] [1]
 *          ^               ^
 *          |               |
 *        write            read
 *
 *  Esta estructura puede tomar distintas estrategias para cuando el buffer esta lleno e intentamos agregar elementos
 *
 *  - Blocking: Se queda bloqueado esperando un slot libre
 *  - Resizing: Incrementa el tamaño del buffer y acomoda los elementos de forma correcta
 *  - Overriding: Sobrescribe los valores que no se consumieron
 *  - Exception: Arroja una excepción cuando esta lleno
 *  - Ignore: Ignora el elemento agregado y deja el buffer sin modificación, es responsabilidad de quien usa el buffer verificar esto
 *
 */
public class CircularBuffer<T> {

    private final T[] elements;

    // Esto representa la posición de escritura
    private int offset = 0;

    // La posición de lectura no es persistida y se calcula en base al numero de elementos sin consumir
    private int available = 0;

    public CircularBuffer(Class<T> clazz, int capacity) {
        elements = (T[]) Array.newInstance(clazz, capacity);
    }

    public boolean enqueue(T value) {
        if (available == elements.length) {
            return false;
        }


        elements[offset] = value;
        offset = (offset + 1) % elements.length;

        available++;
        return true;
    }

    public T dequeue() {
        if (available == 0) {
            return null;
        }

        int head = computeHead();
        T value = elements[head];
        elements[head] = null;
        available--;
        return value;
    }

    private int capacity() {
        return elements.length;
    }

    private int computeHead() {
        return (offset + (capacity() - available)) % capacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Head: ");
        sb.append(computeHead());
        sb.append("\n");
        sb.append("Tail: ");
        sb.append(offset);
        sb.append("\n");
        sb.append(Arrays.toString(elements));
        return sb.toString();
    }
}