import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> adjacencyMap;
    public WeightedGraph() {
        adjacencyMap = new HashMap<>();
    }
    public void addVertex(Vertex<V> vertex) {
        adjacencyMap.put(vertex, new ArrayList<>());
    }
    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        List<Vertex<V>> adjacentVertices = adjacencyMap.get(source);
        adjacentVertices.add(destination);

        source.addAdjVertex(destination, weight);
    }
    public List<Vertex<V>> getAdjacentVertices(Vertex<V> vertex) {
        return adjacencyMap.get(vertex);
    }
}