public class Edge<Vertex> {
    private Vertex source;
    private Vertex dest;
    private Double weight;
    /**
     * Constructs an edge between two vertices with a specified weight.
     *
     * @param source the source vertex of the edge
     * @param dest   the destination vertex of the edge
     * @param weight the weight of the edge
     */
    public Edge(Vertex source, Vertex dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
    /**
     * Retrieves the source vertex of the edge.
     *
     * @return the source vertex
     */
    public Vertex getSource() {
        return source;
    }
    /**
     * Sets the source vertex of the edge.
     *
     * @param source the source vertex to set
     */
    public void setSource(Vertex source) {
        this.source = source;
    }
    /**
     * Retrieves the destination vertex of the edge.
     *
     * @return the destination vertex
     */
    public Vertex getDest() {
        return dest;
    }
    /**
     * Sets the destination vertex of the edge.
     *
     * @param dest the destination vertex to set
     */
    public void setDest(Vertex dest) {
        this.dest = dest;
    }
    /**
     * Retrieves the weight of the edge.
     *
     * @return the weight of the edge
     */
    public Double getWeight() {
        return weight;
    }
    /**
     * Sets the weight of the edge.
     *
     * @param weight the weight to set
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }
}