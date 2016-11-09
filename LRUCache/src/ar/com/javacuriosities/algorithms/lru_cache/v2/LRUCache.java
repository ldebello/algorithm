package ar.com.javacuriosities.algorithms.lru_cache.v2;

import ar.com.javacuriosities.algorithms.lru_cache.Cache;

import java.util.HashMap;
import java.util.Map;

/*
 * Esta implementación utiliza un Hash para buscar en base a la Key el Nodo correspondiente
 * y cada Nodo tiene una referencia al siguiente y al anterior
 *
 */
public class LRUCache<K, V> implements Cache<K, V> {

    private int capacity;

    private Node<K, V> head;
    private Node<K, V> end;

    private Map<K, Node<K, V>> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        // Existing key
        if (cache.containsKey(key)) {
            // Move to first place
            Node<K, V> node = cache.get(key);

            moveFirst(node);

            // Return the value
            return node.value;
        }

        // Not found
        return null;
    }

    public void set(K key, V value) {
        // Existing slot
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            this.moveFirst(node);
            node.value = value;
            return;
        }

        // Out of capacity, cleaning the oldest slot
        if (cache.size() >= this.capacity) {
            K oldKey = this.end.key;

            removeLast();
            cache.remove(oldKey);
        }

        // New slot
        Node node = new Node(key, value);


        add(node);
        cache.put(key, node);
    }

    @Override
    public String toString() { return cache.toString(); }

    private void moveFirst(Node<K, V> node) {
        this.remove(node);
        this.add(node);
    }

    private void removeLast() {
        this.remove(this.end);
    }

    private void add(Node<K, V> node) {
        // Reset position
        node.next = null;
        node.previous = null;

        // First element
        if (null == this.head) {
            this.head = node;
            this.end = node;
            return;
        }

        // Existing element
        this.head.previous = node;
        node.next = this.head;
        this.head = node;
    }

    private void remove(Node<K, V> node) {
        // Nothing to do
        if (this.head == null || null == node) {
            return;
        }

        // The only one item
        if (this.head == this.end && this.head == node) {
            this.head = null;
            this.end = null;
            return;
        }

        // Remove from head
        if (node == this.head) {
            this.head.next.previous = null;
            this.head = this.head.next;
            return;
        }

        // Remove from end
        if (node == this.end) {
            this.end.previous.next = null;
            this.end = this.end.previous;
            return;
        }

        // Remove in the middle
        node.previous.next = node.next;
        node.next.previous = node.previous;

    }

    private static class Node<K, V> {
        private K key;
        private V value;

        private Node<K, V> previous;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}