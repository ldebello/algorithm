package ar.com.javacuriosities.algorithms.disjointset.v3;

import java.util.Arrays;

/*
 * Disjointset con PathCompression y Union by Rank
 *
 * Union by Rank puede ser aplicado con o sin PathCompression, pero para este ejemplo
 * partiremos desde la v2 y incluiremos esta mejora.
 *
 * Esta técnica intenta reducir el alto de los tree y para esto utiliza un array llamado "rank" con el
 * alto de los tree
 *
 */
public class DisjointSet {

    private int[] parent;
    private int[] rank;

    public DisjointSet(int numberOfElements) {
        parent = new int[numberOfElements];
        rank = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            parent[i] = i;
            rank[i] = 0;
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

    /*
     * Un extra bonus de esta implementación es que retorna true cuando los elementos
     * son realmente mergeados y false si ya eran parte del mismo grupo.
     */
    public boolean union(int x, int y) {
        int xx = find(x);
        int yy = find(y);

        if (xx == yy) {
            return false;
        }

        int xxRank = rank[xx];
        int yyRank = rank[yy];

        // Nos aseguramos que de tener el tree de menor profundidad
        if (xxRank > yyRank) {
            int aux = xx;
            xx = yy;
            yy = aux;
        }

        if (rank[xx] == rank[yy]) rank[yy]++;

        parent[xx] = yy;
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(parent) + "\n" + Arrays.toString(rank);
    }
}
