package ar.com.javacuriosities.algorithms.disjointset.v1;

public class Main {
    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(8);

        int set1 = disjointSet.find(6);
        int set2 = disjointSet.find(7);
        disjointSet.union(set1, set2);

        set1 = disjointSet.find(6);
        set2 = disjointSet.find(2);
        disjointSet.union(set1, set2);

        set1 = disjointSet.find(5);
        set2 = disjointSet.find(2);
        disjointSet.union(set1, set2);

        set1 = disjointSet.find(1);
        set2 = disjointSet.find(2);
        disjointSet.union(set1, set2);

        set1 = disjointSet.find(0);
        set2 = disjointSet.find(4);
        disjointSet.union(set1, set2);

        set1 = disjointSet.find(0);
        set2 = disjointSet.find(3);
        disjointSet.union(set1, set2);

        System.out.println(disjointSet);
    }
}
