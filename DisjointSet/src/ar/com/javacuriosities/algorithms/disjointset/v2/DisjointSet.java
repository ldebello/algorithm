package ar.com.javacuriosities.algorithms.disjointset.v2;

import java.util.Arrays;

/*
 * Disjointset con PathCompression
 *
 * Si tomamos como punto de partida la v1 vemos que el método union invoca dos
 * veces el método find y este depende de la profundidad del tree
 *
 * Esta técnica hace un caching del nodo obtenido, o sea termina apuntando al nodo representativo (Root) de ese conjunto
 */
public class DisjointSet {

    private int[] parent;

    public DisjointSet(int numberOfElements) {
        parent = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    @Override
    public String toString() {
        return Arrays.toString(parent);
    }
}
