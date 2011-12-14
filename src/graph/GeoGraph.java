package graph;

/**
 *
 * @author sok
 */
public class GeoGraph implements WeightedGraph
{
    private boolean directed;
	private Point graph[];
    
    public GeoGraph(Point[] point)
    {
        this.graph = point;
        this.directed = false;
    }
    
    /**
	 * Returns the amount of knots of the graph
	 * 
	 * @return int Amount of the knots  
	 */
	@Override
    public int size()
    {
        return this.graph.length;
    }
	
	/**
	 * Returns true if the graph is directed, false otherwise
	 * 
	 * @return boolean
	 */
	@Override
    public boolean isDirected()
    {
        return this.directed ? true : false;
    }
	
	/**
	 * Returns the weight not existant edges
	 * 
	 * @return double
	 */
	@Override
    public double noEdge()
    {
        return Double.POSITIVE_INFINITY;
    }
	
	/**
	 * Set the weight x of the knots i and j
	 * 
	 * @param int i 
	 * @param int j
	 * @param double x  the weight of knots
	 */
	@Override
    public void setWeight(int i, int j, double x)
    {
        // Will not implemented
    }
	
	/**
	 * Returns the weight of edge i and j
	 * 
	 * @param int i start knot
	 * @param int j end knot
	 * 
	 * @return double the weight of the edge
	 */
	@Override
    public double getWeight(int i, int j)
    {
        return this.graph[i].distanceTo(this.graph[j]);
    }

    
	/**
	 * Deletes the edge i of j
	 * @param int i start knot
	 * @param int j end knot 
	 */
    @Override
	public void deleteEdge(int i, int j)
    {
        // Will not implemented   
    }

	
	/**
	 * Returns true if i and j is an edge
	 * 
	 * @param int i start knot
	 * @param int j end knot
	 * @return boolean
	 */
    @Override
	public boolean isEdge(int i, int j)
    {
        boolean result = true;
        
        if (this.getWeight(i, j) == this.noEdge())
        {
            result = false;
        }
        
        return result;
    }

}
