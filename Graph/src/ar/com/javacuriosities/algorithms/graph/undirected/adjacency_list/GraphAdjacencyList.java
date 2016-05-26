package ar.com.javacuriosities.algorithms.graph.undirected.adjacency_list;


import ar.com.javacuriosities.algorithms.graph.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;

public class GraphAdjacencyList<T> implements Graph<T> {


    private Map<T, List<T>> adjacencyList;

    public GraphAdjacencyList() {
        adjacencyList = new HashMap<>();
    }

    @Override
    public void addEdge(T source, T target) {
        List<T> sourceNeighbors = adjacencyList.getOrDefault(source, new LinkedList<>());
        sourceNeighbors.add(target);

        List<T> targetNeighbors = adjacencyList.getOrDefault(target, new LinkedList<>());
        targetNeighbors.add(source);

        adjacencyList.put(source, sourceNeighbors);
        adjacencyList.put(target, targetNeighbors);
    }

    @Override
    public void removeEdge(T source, T target) {
        adjacencyList.remove(source);
        adjacencyList.remove(target);
    }

    @Override
    public boolean isEdge(T source, T target) {
        return adjacencyList.containsKey(source);
    }

    @Override
    public List<T> getAdjacencies(T source) {
        return adjacencyList.getOrDefault(source, new LinkedList<>());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<T, List<T>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" ");
            sb.append("->");
            sb.append(" ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }
}