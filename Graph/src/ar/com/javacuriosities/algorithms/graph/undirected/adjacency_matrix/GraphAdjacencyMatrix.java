package ar.com.javacuriosities.algorithms.graph.undirected.adjacency_matrix;

import ar.com.javacuriosities.algorithms.graph.Graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GraphAdjacencyMatrix implements Graph<Integer> {

    private int vertices;
    private int adjacencyMatrix[][];

    public GraphAdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    @Override
    public void addEdge(Integer source, Integer target) {
        source--;
        target--;
        boolean sourceIsInRange = source >= 0 && source < vertices;
        boolean targetIsInRange = target >= 0 && source < vertices;
        if (sourceIsInRange && targetIsInRange) {
            adjacencyMatrix[source][target] = 1;
            adjacencyMatrix[target][source] = 1;
        }
    }

    @Override
    public void removeEdge(Integer source, Integer target) {
        source--;
        target--;
        boolean sourceIsInRange = source >= 0 && source < vertices;
        boolean targetIsInRange = target >= 0 && source < vertices;
        if (sourceIsInRange && targetIsInRange) {
            adjacencyMatrix[source][target] = 0;
            adjacencyMatrix[target][source] = 0;
        }
    }

    @Override
    public boolean isEdge(Integer source, Integer target) {
        source--;
        target--;
        boolean sourceIsInRange = source >= 0 && source < vertices;
        boolean targetIsInRange = target >= 0 && source < vertices;
        return (sourceIsInRange && targetIsInRange) && adjacencyMatrix[source][target] == 1;
    }

    @Override
    public List<Integer> getAdjacencies(Integer source) {
        source--;
        boolean sourceIsInRange = source >= 0 && source < vertices;
        return sourceIsInRange ? buildAdjacenciesList(adjacencyMatrix[source]) : Collections.EMPTY_LIST;
    }

    private List<Integer> buildAdjacenciesList(int[] values) {
        List<Integer> adjacencies = new LinkedList<>();
        for (int index = 0; index < values.length; index++) {
            if (values[index] != 0) {
                adjacencies.add(index + 1);
            }
        }
        return adjacencies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= vertices; i++) {
            sb.append(i);
            sb.append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < vertices; i++) {
            sb.append(i+1);
            sb.append(" ");
            for (int value : adjacencyMatrix[i]) {
                sb.append(value);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}