package ar.com.javacuriosities.algorithms.graph;

import java.util.List;

public interface Graph<T> {

    public void addEdge(T source, T target);

    public void removeEdge(T source, T target);

    public boolean isEdge(T source, T target);

    public List<T> getAdjacencies(T source);
}
