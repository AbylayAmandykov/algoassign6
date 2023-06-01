import java.util.*;

public class MyGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> list;
    /**
     * empty graph.
     */
    public MyGraph() {
        list = new HashMap<>();
    }
    /**
     * Adds a vertex to the graph.
     *
     * @param vertex the vertex to be added
     */
    public void addVertex(Vertex vertex) {
        list.put(vertex, new LinkedList<>());
    }
    /**
     * Adds an edge with a weight between two vertices in the graph
     *
     * @param source      the source vertex of the edge
     * @param destination the destination vertex of the edge
     * @param weight      the weight of the edge
     */
    public void addEdge(Vertex source, Vertex destination, double weight) {
        validateVertex(source);
        validateVertex(destination);

        list.get(source).add(new Edge<>(source, destination, weight));
        list.get(destination).add(new Edge<>(destination, source, weight));
    }
    /**
     * Validates if a vertex exists in the graph
     *
     * @param index the vertex to validate
     * @throws IllegalArgumentException if the vertex is not found in the graph
     */
    private void validateVertex(Vertex index) {
        if (!list.containsKey(index)) {
            throw new IllegalArgumentException("Vertex " + index + " is out of the range");
        }
    }
    /**
     * Prints the graph
     */
    public void printGraph() {
        for (Map.Entry<Vertex, List<Edge<Vertex>>> entry : list.entrySet()) {
            Vertex vertex = entry.getKey();
            List<Edge<Vertex>> edges = entry.getValue();

            System.out.print("Vertex " + vertex + " is connected to: ");
            for (Edge<Vertex> edge : edges) {
                System.out.print(edge.getDest() + " ");
            }
            System.out.println();
        }
    }
    /**
     * Removes an edge between two vertices in the graph
     *
     * @param source      the source vertex of the edge
     * @param destination the destination vertex of the edge
     */
    public void removeEdge(Vertex source, Vertex destination) {
        validateVertex(source);
        validateVertex(destination);

        List<Edge<Vertex>> edges = list.get(source);
        if (edges != null) {
            edges.removeIf(edge -> edge.getDest().equals(destination));
        }

        edges = list.get(destination);
        if (edges != null) {
            edges.removeIf(edge -> edge.getDest().equals(source));
        }
    }
    /**
     * Checks if an edge exists between two vertices in the graph
     *
     * @param source      the source vertex of the edge
     * @param destination the destination vertex of the edge
     * @return true if an edge exists, false otherwise
     */
    public boolean hasEdge(Vertex source, Vertex destination) {
        validateVertex(source);
        validateVertex(destination);

        List<Edge<Vertex>> edges = list.get(source);
        if (edges != null) {
            for (Edge<Vertex> edge : edges) {
                if (edge.getDest().equals(destination)) {
                    return true;
                }
            }
        }

        return false;
    }
    /**
     * Performs Dijkstra's algorithm to find the shortest distances from a source vertex to all other vertices
     *
     * @param source the source vertex
     * @return a map containing the shortest distances from the source vertex to each vertex in the graph
     */
    public Map<Vertex, Double> dijkstra(Vertex source) {
        validateVertex(source);

        Map<Vertex, Double> distances = new HashMap<>();
        PriorityQueue<WeightedGraph<Vertex>> pq = new PriorityQueue<>();

        for (Vertex vertex : list.keySet()) {
            if (vertex.equals(source)) {
                distances.put(vertex, 0.0);
            } else {
                distances.put(vertex, Double.POSITIVE_INFINITY);
            }
            pq.offer(new WeightedGraph<>(vertex, distances.get(vertex)));
        }

        while (!pq.isEmpty()) {
            WeightedGraph<Vertex> current = pq.poll();
            Vertex currentVertex = current.getVertex();

            if (distances.get(currentVertex) < current.getDistance()) {
                continue;
            }

            List<Edge<Vertex>> edges = list.get(currentVertex);
            if (edges != null) {
                for (Edge<Vertex> edge : edges) {
                    Vertex neighbor = edge.getDest();
                    double newDistance = distances.get(currentVertex) + edge.getWeight();

                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        pq.offer(new WeightedGraph<>(neighbor, newDistance));
                    }
                }
            }
        }

        return distances;
    }
    /**
     * Performs a depth-first search (DFS) starting from a given vertex
     *
     * @param start the starting vertex for the DFS
     */
    public void DFS(Vertex start) {
        validateVertex(start);
        Map<Vertex, Boolean> visited = new HashMap<>();
        for (Vertex vertex : list.keySet()) {
            visited.put(vertex, false);
        }
        DFSHelper(start, visited);
    }
    /**
     * Helper method for DFS traversal
     * @param vertex  The current vertex
     * @param visited A map to track visited vertices
     */
    private void DFSHelper(Vertex vertex, Map<Vertex, Boolean> visited) {
        visited.put(vertex, true);
        System.out.print(vertex + " ");

        List<Edge<Vertex>> edges = list.get(vertex);
        if (edges != null) {
            for (Edge<Vertex> edge : edges) {
                Vertex neighbor = edge.getDest();
                if (!visited.get(neighbor)) {
                    DFSHelper(neighbor, visited);
                }
            }
        }
    }
    /**
     * Performs a Breadth-First Search traversal starting from a given vertex
     * @param start The vertex from which to start the BFS traversal
     */
    public void BFS(Vertex start) {
        validateVertex(start);
        Map<Vertex, Boolean> visited = new HashMap<>();
        for (Vertex vertex : list.keySet()) {
            visited.put(vertex, false);
        }

        Queue<Vertex> queue = new LinkedList<>();
        visited.put(start, true);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current + " ");

            List<Edge<Vertex>> edges = list.get(current);
            if (edges != null) {
                for (Edge<Vertex> edge : edges) {
                    Vertex neighbor = edge.getDest();
                    if (!visited.get(neighbor)) {
                        visited.put(neighbor, true);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}
