import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Your implementation of various different graph algorithms.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * {@code start} which represents the starting vertex.
     * <p>
     * When exploring a vertex, make sure to explore in the order that the
     * adjacency list returns the neighbors to you. Failure to do so may cause
     * you to lose points.
     * <p>
     * You may import/use {@code java.util.Set}, {@code java.util.List},
     * {@code java.util.Queue}, and any classes that implement the
     * aforementioned interfaces, as long as it is efficient.
     * <p>
     * The only instance of {@code java.util.Map} that you may use is the
     * adjacency list from {@code graph}. DO NOT create new instances of Map
     * for BFS (storing the adjacency list in a variable is fine).
     * <p>
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start the vertex to begin the bfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     * @throws IllegalArgumentException if any input is null, or if {@code
     * start} doesn't exist in the graph
     */
    public static <T> List<Vertex<T>> breadthFirstSearch(Vertex<T> start,
                                                         Graph<T> graph) {
        if (start == null) {
            throw new IllegalArgumentException("error: cannot search a null "
                    + "start");
        }
        if (graph == null) {
            throw new IllegalArgumentException("error: cannot search a null "
                    + "graph");
        }
        Set<Vertex<T>> vertices = graph.getVertices();
        if (!vertices.contains(start)) {
            throw new IllegalArgumentException("error: start is not in the "
                    + "graph");
        }

        List<Vertex<T>> result = new ArrayList<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        Set<Vertex<T>> visited = new HashSet<>();
        Map<Vertex<T>, List<Edge<T>>> adjList = graph.getAdjList();

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Vertex<T> currVertex = queue.remove();
            result.add(currVertex);
            for (Edge<T> edge : adjList.get(currVertex)) {
                if (!visited.contains(edge.getV())) {
                    queue.add(edge.getV());
                    visited.add(edge.getV());
                }
            }

        }
        return result;
    }


    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * {@code start} which represents the starting vertex.
     * <p>
     * When deciding which neighbors to visit next from a vertex, visit the
     * vertices in the order presented in that entry of the adjacency list.
     * <p>
     * *NOTE* You MUST implement this method recursively, or else you will lose
     * most if not all points for this method.
     * <p>
     * You may import/use {@code java.util.Set}, {@code java.util.List}, and
     * any classes that implement the aforementioned interfaces, as long as it
     * is efficient.
     * <p>
     * The only instance of {@code java.util.Map} that you may use is the
     * adjacency list from {@code graph}. DO NOT create new instances of Map
     * for DFS (storing the adjacency list in a variable is fine).
     * <p>
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start the vertex to begin the dfs on
     * @param graph the graph to search through
     * @return list of vertices in visited order
     * @throws IllegalArgumentException if any input is null, or if {@code
     * start} doesn't exist in the graph
     */
    public static <T> List<Vertex<T>> depthFirstSearch(Vertex<T> start,
                                                       Graph<T> graph) {
        if (start == null) {
            throw new IllegalArgumentException("error: cannot search a null "
                    + "start");
        }
        if (graph == null) {
            throw new IllegalArgumentException("error: cannot search a null "
                    + "graph");
        }
        Set<Vertex<T>> vertices = graph.getVertices();
        if (!vertices.contains(start)) {
            throw new IllegalArgumentException("error: start is not in the "
                    + "graph");
        }

        List<Vertex<T>> result = new ArrayList<>();
        Set<Vertex<T>> visited = new HashSet<>();
        Map<Vertex<T>, List<Edge<T>>> adjList = graph.getAdjList();

        realDepthFirst(start, visited, adjList, result);

        return result;
    }

    /**
     * Helper method for depthFirstSearch()
     * actually does the searching recursively
     *
     * @param currVertex the current vertex (input should be start)
     * @param visited    the set of visited vertices
     * @param adjList    the adjacency list of the graph
     * @param result     the result of vertices that gets returned
     * @param <T>        the generic typing of the data
     */
    private static <T> void realDepthFirst(Vertex<T> currVertex,
                                           Set<Vertex<T>> visited,
                                           Map<Vertex<T>, List<Edge<T>>>
                                                   adjList,
                                           List<Vertex<T>> result) {
        result.add(currVertex);
        visited.add(currVertex);

        for (Edge<T> edge : adjList.get(currVertex)) {
            if (!visited.contains(edge.getV())) {
                realDepthFirst(edge.getV(), visited, adjList, result);
            }
        }
    }


    /**
     * Finds the single-source shortest distance between the start vertex and
     * all vertices given a weighted graph (you may assume non-negative edge
     * weights).
     * <p>
     * Return a map of the shortest distances such that the key of each entry
     * is a node in the graph and the value for the key is the shortest distance
     * to that node from start, or Integer.MAX_VALUE (representing infinity)
     * if no path exists.
     * <p>
     * You may import/use {@code java.util.PriorityQueue},
     * {@code java.util.Map}, and {@code java.util.Set} and any class that
     * implements the aforementioned interfaces, as long as it's efficient.
     * <p>
     * You should implement the version of Dijkstra's where you terminate the
     * algorithm once either all vertices have been visited or the PQ becomes
     * empty.
     * <p>
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start index representing which vertex to start at (source)
     * @param graph the graph we are applying Dijkstra's to
     * @return a map of the shortest distances from start to every other node
     * in the graph
     * @throws IllegalArgumentException if any input is null, or if start
     *                                  doesn't exist in the graph.
     */
    public static <T> Map<Vertex<T>, Integer> dijkstras(Vertex<T> start,
                                                        Graph<T> graph) {
        if (start == null) {
            throw new IllegalArgumentException("error: cannot search a null "
                    + "start");
        }
        if (graph == null) {
            throw new IllegalArgumentException("error: cannot search a null "
                    + "graph");
        }
        Set<Vertex<T>> vertices = graph.getVertices();
        if (!vertices.contains(start)) {
            throw new IllegalArgumentException("error: start is not in the "
                    + "graph");
        }

        Map<Vertex<T>, List<Edge<T>>> adjList = graph.getAdjList();
        Map<Vertex<T>, Integer> result = new HashMap<>();

        for (Vertex<T> vertex : vertices) {
            if (vertex.equals(start)) {
                result.put(vertex, 0);
            } else {
                result.put(vertex, Integer.MAX_VALUE);
            }
        }

        Queue<Edge<T>> distQ = new PriorityQueue<>();
        distQ.add(new Edge<>(start, start, 0));

        while (!distQ.isEmpty()) {
            Edge<T> vertexWithDist = distQ.remove();
            Vertex<T> currU = vertexWithDist.getV();

            for (Edge<T> currEdge : adjList.get(currU)) {
                Vertex<T> currV = currEdge.getV();
                if (result.get(currV)
                        > currEdge.getWeight() + vertexWithDist.getWeight()) {
                    result.put(currV,
                            currEdge.getWeight() + vertexWithDist.getWeight());
                    distQ.add(new Edge<T>(start, currV,
                            currEdge.getWeight()
                                    + vertexWithDist.getWeight()));
                }
            }
        }

        return result;

    }

    /**
     * Runs Prim's algorithm on the given graph and return the Minimal
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     * <p>
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     * <p>
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * opposite edge to the set as well. This is for testing purposes.
     * <p>
     * You may assume that there will only be one valid MST that can be formed.
     * <p>
     * You should NOT allow self-loops into the MST.
     * <p>
     * You may import/use {@code java.util.PriorityQueue},
     * {@code java.util.Set}, and any class that implements the aforementioned
     * interface, as long as it's efficient.
     * <p>
     * The only instance of {@code java.util.Map} that you may use is the
     * adjacency list from {@code graph}. DO NOT create new instances of Map
     * for this method (storing the adjacency list in a variable is fine).
     * <p>
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     *
     * @param <T>   the generic typing of the data
     * @param start the vertex to begin Prims on
     * @param graph the graph we are applying Prims to
     * @return the MST of the graph or null if there is no valid MST
     * @throws IllegalArgumentException if any input is null, or if {@code
     * start} doesn't exist in the graph
     */
    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        if (start == null) {
            throw new IllegalArgumentException("error: cannot search a null "
                    + "start");
        }
        if (graph == null) {
            throw new IllegalArgumentException("error: cannot search a null "
                    + "graph");
        }
        Set<Vertex<T>> vertices = graph.getVertices();
        if (!vertices.contains(start)) {
            throw new IllegalArgumentException("error: start is not in the "
                    + "graph");
        }
        Set<Edge<T>> mst = new HashSet<>();
        Map<Vertex<T>, List<Edge<T>>> adjList = graph.getAdjList();
        Queue<Edge<T>> edgePrioQ = new PriorityQueue<>();
        Set<Vertex<T>> resultVertices = new HashSet<>();

        edgePrioQ.addAll(adjList.get(start));
        while (!edgePrioQ.isEmpty()) {
            Edge<T> minEdge = edgePrioQ.remove();
            if (!mst.contains(minEdge)
                    && !resultVertices.contains(minEdge.getV())) {
                mst.add(new Edge<>(minEdge.getU(), minEdge.getV(),
                        minEdge.getWeight()));
                mst.add(new Edge<>(minEdge.getV(), minEdge.getU(),
                        minEdge.getWeight()));
                edgePrioQ.addAll(adjList.get(minEdge.getV()));
                resultVertices.add(minEdge.getU());
                resultVertices.add(minEdge.getV());
            }
        }

        return mst.size() < 2 * (graph.getVertices().size() - 1) ? null : mst;
    }
}