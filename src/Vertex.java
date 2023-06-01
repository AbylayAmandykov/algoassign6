import java.util.HashMap;
import java.util.Map;
public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjVertices;
    /**
     * Constructs a vertex with the specified data
     *
     * @param data the data associated with the vertex
     */
    public Vertex(V data) {
        this.data = data;
        this.adjVertices = new HashMap<>();
    }
    /**
     * Adds an adjacent vertex with a specified weight
     *
     * @param dest   the adjacent vertex
     * @param weight the weight of the edge connecting this vertex to the adjacent vertex
     */
    public void addAdjVertex(Vertex<V> dest, double weight) {
        adjVertices.put(dest, weight);
    }
    /**
     * Retrieves the map of adjacent vertices and their associated weights.
     *
     * @return the map of adjacent vertices and weights
     */
    public Map<Vertex<V>, Double> getAdjVertices() {
        return adjVertices;
    }
    /**
     * Returns a string representation of the vertex.
     *
     * @return a string representation of the vertex
     */
    @Override
    public String toString() {
        return "Vertex " + this.data;
    }
}