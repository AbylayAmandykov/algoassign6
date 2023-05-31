class WeightedGraph<Vertex> implements Comparable<WeightedGraph> {
    private Vertex vertex;
    private double distance;

    public WeightedGraph(Vertex vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

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