package graph;

/**
 * This is an interface of a WeightedGraph
 * 
 * @author Finn Kondering 399083
 * @author Stefano Kowalke 485366
 */
public interface WeightedGraph
{
    /**
     * Returns the amount of knots of the graph
     * 
     * @return Amount of the knots  
     */
    public int Size();

    /**
     * Returns true if the graph is directed, false otherwise
     * 
     * @return True if the graph is directed, false otherwise
     */
    public boolean isDirected();

    /**
     * Returns the weight not existant edges
     * 
     * @return The weight not existant edges
     */
    public double noEdge();

    /**
     * Set the weight x of the edge i and j
     * 
     * @param i First point
     * @param j Second point
     * @param x The weight of edge
     */
    public void setWeight(int i, int j, double x);

    /**
     * Returns the weight of edge i and j
     * 
     * @param i First point
     * @param j Second point
     * 
     * @return The weight of the edge
     */
    public double getWeight(int i, int j);

    /**
     * Deletes the edge i and j
     * 
     * @param i First point
     * @param j Fecond point
     */
    public void deleteEdge(int i, int j);

    /**
     * Returns true if i and j is an edge
     * 
     * @param i First point
     * @param j Second point
     * @return True if i and j is an edge
     */
    public boolean isEdge(int i, int j);
}
