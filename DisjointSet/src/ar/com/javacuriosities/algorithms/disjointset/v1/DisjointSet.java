package ar.com.javacuriosities.algorithms.disjointset.v1;

import java.util.Arrays;

/*
 * Esta es la version mas simple de DisjointSet que podemos obtener
 * Dos mejoras típicas son:
 *
 * PathCompression
 * Union by Rank
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
            return find(parent[x]);
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
