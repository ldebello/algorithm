package ar.com.javacuriosities.algorithms.lru_cache.v4;

import ar.com.javacuriosities.algorithms.lru_cache.Cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/*
 * Esta implementación es similar a la v3, pero además agrega otro Hash del tipo WeakHashMap, lo cual nos permite
 * mantener los elementos que ya fueron removidos, hasta que el GC los junte de la memoria y nos permite buscar primero
 * en la MRU (Most Recently Used) y si no se encuentra buscarlo en la LRU, lo cual puede ser factible para elementos
 * que expiraron hace poco tiempo, lo cual es una buena forma de sugerir al cliente que puede agrandar el cache size
 * para evitar este miss en la cache que busca un elemento recién expirado
 *
 */
public class LRUCache<K, V> implements Cache<K, V> {

    private final Map<K, V> MRUdata;
    private final Map<K, V> LRUdata;

    public LRUCache(final int capacity) {
        LRUdata = new WeakHashMap<K, V>();

        MRUdata = new LinkedHashMap<K, V>(capacity + 1, 1.0f, true) {
            protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
                if (this.size() > capacity) {
                    LRUdata.put(entry.getKey(), entry.getValue());
                    return true;
                }
                return false;
            }
        };
    }

    public V get(K key) {
        V value = MRUdata.get(key);
        if (value != null) {
            return value;
        }
        value = LRUdata.get(key);
        if (value != null) {
            LRUdata.remove(key);
            MRUdata.put(key, value);
        }
        return value;
    }

    public void set(K key, V value) {
        LRUdata.remove(key);
        MRUdata.put(key, value);
    }

    @Override
    public String toString() { return MRUdata.toString(); }
}