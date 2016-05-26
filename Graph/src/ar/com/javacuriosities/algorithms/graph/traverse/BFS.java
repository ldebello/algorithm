package ar.com.javacuriosities.algorithms.graph.traverse;

import ar.com.javacuriosities.algorithms.graph.Graph;

import java.util.*;

public class BFS {
    public <T> void traverse(Graph<T> graph, T startVertex) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<T>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            T vertex = queue.remove();
            System.out.println(vertex);

            List<T> adjacencies = graph.getAdjacencies(vertex);
            for (T adjacency: adjacencies) {
                if (!visited.contains(adjacency)) {
                    queue.add(adjacency);
                    visited.add(adjacency);
                }
            }
        }
    }
}
