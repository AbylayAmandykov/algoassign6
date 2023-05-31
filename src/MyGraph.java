import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class MyGraph<Vertex> {
    private Map<Vertex, List<Vertex>> list;
    public MyGraph() {
        list = new HashMap<>();
    }
    public void addVertex(Vertex vertex) {
        list.put(vertex, new LinkedList<>());
    }
    public void addEdge(Vertex source, Vertex destination) {
        validateVertex(source);
        validateVertex(destination);
        list.get(source).add(destination);
        list.get(destination).add(source);
    }
    private void validateVertex(Vertex index) {
        if (!list.containsKey(index)) {
            throw new IllegalArgumentException("Vertex " + index + " is out of the range");
        }
    }
    public void printGraph() {
        for (Map.Entry<Vertex, List<Vertex>> entry : list.entrySet()) {
            Vertex vertex = entry.getKey();
            List<Vertex> neighbors = entry.getValue();
            System.out.print("Vertex " + vertex + " is connected to: ");
            for (Vertex neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}