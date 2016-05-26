package ar.com.javacuriosities.algorithms.graph.undirected.adjacency_list;

import ar.com.javacuriosities.algorithms.graph.Graph;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new GraphAdjacencyList<>();

        graph.addEdge(1, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);

        System.out.println("Adjacency List");
        System.out.println(graph);

        System.out.println("4 -> 3 Is Edge? " + graph.isEdge(4, 3));
        System.out.println("4 -> 2 Is Edge? " + graph.isEdge(4, 2));

        System.out.println("Adjacencies of 4: " + graph.getAdjacencies(4));
    }
}
