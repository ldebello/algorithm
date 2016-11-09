package ar.com.javacuriosities.algorithms.lru_cache.v3;

import ar.com.javacuriosities.algorithms.lru_cache.Cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/*
 * Esta implementación utiliza un LinkedHashMap el cual es un HashMap que preserva el orden de inserción
 * y además nos provee la funcionalidad de remover el elemento mas antiguo de forma automatica
 *
 */
public class LRUCache<K, V> implements Cache<K, V> {

    private final Map<K, V> MRUdata;

    public LRUCache(final int capacity) {
        MRUdata = new LinkedHashMap<K, V>(capacity + 1, 1.0f, true) {
            protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
                return this.size() > capacity;
            }
        };
    }

    public V get(K key) {
        return MRUdata.get(key);
    }

    public void set(K key, V value) {
        MRUdata.put(key, value);
    }

    @Override
    public String toString() { return MRUdata.toString(); }
}