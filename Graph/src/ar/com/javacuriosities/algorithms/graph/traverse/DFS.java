package ar.com.javacuriosities.algorithms.graph.traverse;

import ar.com.javacuriosities.algorithms.graph.Graph;

import java.util.*;

public class DFS {

    public <T> void iterativeTraverse(Graph<T> graph, T startVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        stack.push(startVertex);
        visited.add(startVertex);

        while(!stack.isEmpty()){
            T vertex = stack.pop();
            System.out.println(vertex);

            List<T> adjacencies = graph.getAdjacencies(vertex);
            for (T adjacency: adjacencies) {
                if (!visited.contains(adjacency)) {
                    stack.push(adjacency);
                    visited.add(adjacency);
                }
            }
            /*
             * Esta es una opción para que nos queda el mismo
             * orden que en la version recursiva, otra opción
             * es iterar la lista en orden inverso
             */
            /*
            Stack<T> aux = new Stack<>();
            List<T> adjacencies = graph.getAdjacencies(vertex);
            for (T adjacency: adjacencies) {
                if (!visited.contains(adjacency)) {
                    aux.push(adjacency);
                }
            }

            while(!aux.isEmpty()){
                T temporalVertex = aux.pop();
                stack.push(temporalVertex);
                visited.add(temporalVertex);
            }
            */
        }
    }

    public <T> void recursiveTraverse(Graph<T> graph, T startVertex) {
        Set<T> visited = new HashSet<>();
        dfsRecursive(graph, startVertex, visited);
    }

    private <T> void dfsRecursive(Graph<T> graph, T startVertex, Set<T> visited) {
        visited.add(startVertex);
        System.out.println(startVertex);

        List<T> adjacencies = graph.getAdjacencies(startVertex);
        for (T adjacency: adjacencies) {
            if (!visited.contains(adjacency)) {
                dfsRecursive(graph, adjacency, visited);
            }
        }
    }
}
