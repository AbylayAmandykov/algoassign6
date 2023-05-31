import java.util.*;

public class MyGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> list;

    public MyGraph() {
        list = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        list.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex destination, double weight) {
        validateVertex(source);
        validateVertex(destination);

        list.get(source).add(new Edge<>(source, destination, weight));
        list.get(destination).add(new Edge<>(destination, source, weight));
    }

    private void validateVertex(Vertex index) {
        if (!list.containsKey(index)) {
            throw new IllegalArgumentException("Vertex " + index + " is out of the range");
        }
    }

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

    public void DFS(Vertex start) {
        validateVertex(start);
        Map<Vertex, Boolean> visited = new HashMap<>();
        for (Vertex vertex : list.keySet()) {
            visited.put(vertex, false);
        }
        DFSHelper(start, visited);
    }

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
