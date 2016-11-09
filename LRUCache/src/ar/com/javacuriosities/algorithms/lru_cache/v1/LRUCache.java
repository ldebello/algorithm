package ar.com.javacuriosities.algorithms.lru_cache.v1;

import ar.com.javacuriosities.algorithms.lru_cache.Cache;

import java.util.HashMap;
import java.util.Map;

/*
 * Esta implementación es muy simple y utiliza dos Hashes para hacer
 * el tracking de los elementos LRU, por medio de un timestamp (Variable auto-incremental).
 *
 * El mayor problema de esta implementación es que utiliza una búsqueda Lineal para encontrar
 * el elemento LRU.
 */
public class LRUCache<K, V> implements Cache<K, V> {

    private int capacity;
    private int timestamp;

    private Map<K, V> cache = new HashMap<>();
    private Map<K, Integer> lru = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            lru.put(key, timestamp);
            timestamp++;
        }
        return value;
    }

    public void set(K key, V value) {
        // Cuando sucede esto debemos remover el elemento que hace mas tiempo no ha sido usado
        if (cache.size() >= capacity && !cache.containsKey(key)) {
            K oldKey = findLRUEntry();
            cache.remove(oldKey);
            lru.remove(oldKey);
        }
        cache.put(key, value);
        lru.put(key, timestamp);
        timestamp++;
    }

    @Override
    public String toString() {
        return cache.toString();
    }

    /*
         * La complejidad de este método es O(n)
         */
    private K findLRUEntry() {
        Map.Entry<K, Integer> minEntry = null;
        for (Map.Entry<K, Integer> entry : lru.entrySet()) {
            if (minEntry == null || entry.getValue() < minEntry.getValue()) {
                minEntry = entry;
            }
        }
        return minEntry.getKey();
    }
}
