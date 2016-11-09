package ar.com.javacuriosities.algorithms.lru_cache.v3;

import ar.com.javacuriosities.algorithms.lru_cache.Cache;

public class Main {
    public static void main(String[] args) {
        Cache<Integer, String> data = new LRUCache<>(4);

        data.set(1, "Cosme");
        data.set(6, "Pedro");
        data.set(8, "Pablo");
        data.set(7, "Sancho");

        System.out.println("Original State");
        System.out.println(data);

        data.set(9, "Juan");

        System.out.println("Key = 1 was removed because it was the least recently used");
        System.out.println(data);

        data.set(6, "Marcos");

        System.out.println("All keys were preserved because we updated one of them");
        System.out.println(data);

        data.set(10, "Fulanito");

        System.out.println("Key = 8 was removed because it became the least recently used after we updated Key 6");
        System.out.println(data);
    }
}
