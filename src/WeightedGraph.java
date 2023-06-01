class WeightedGraph<Vertex> implements Comparable<WeightedGraph> {
    private Vertex vertex;
    private double distance;
    /**
     * Constructs a weighted graph with a vertex and its distance
     *
     * @param vertex   the vertex of the graph
     * @param distance the distance associated with the vertex
     */
    public WeightedGraph(Vertex vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
    /**
     * Compares this weighted graph with another weighted graph based on their distances
     *
     * @param other the other weighted graph to compare
     * @return -1 if this distance is less than the other distance, 0 if they are equal, 1 otherwise
     */
    @Override
    public int compareTo(WeightedGraph other) {
        return Integer.compare((int)distance, (int)other.distance);
    }

    public Vertex getVertex() {
        return vertex;
    }

    public double getDistance() {
        return distance;
    }
}