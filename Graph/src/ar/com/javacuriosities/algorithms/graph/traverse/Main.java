package ar.com.javacuriosities.algorithms.graph.traverse;

import ar.com.javacuriosities.algorithms.graph.Graph;
import ar.com.javacuriosities.algorithms.graph.undirected.adjacency_list.GraphAdjacencyList;

public class Main {
    public static void main(String[] args) {
        DFS dfs = new DFS();
        BFS bfs = new BFS();

        Graph<Integer> graph = new GraphAdjacencyList<>();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("Graph Adjacencies");
        System.out.println(graph);

        System.out.println("DFS Iterative Traverse");
        dfs.iterativeTraverse(graph, 1);

        System.out.println("DFS Recursive Traverse");
        dfs.recursiveTraverse(graph, 1);

        System.out.println("BFS Traverse");
        bfs.traverse(graph, 1);
    }
}
