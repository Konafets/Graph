package graph;


/**
 * This class implements a graph
 * 
 * @author Finn Kondering 399083
 * @author Stefano Kowalke 485366
 */
public class Graph implements WeightedGraph
{
	private boolean directed;
	private double Graph[][];
	
	/**
	 * 
	 * @param Size     The size of the the graph
	 * @param directed Set the graph as directed or not directed
	 */
	Graph(int size, boolean directed)
	{
		this.directed = directed;
		this.Graph = new double[size - 1][size - 1];
		for(int i = 0; i < Size(); i++)
		{
			for(int j = 0; j < Size(); j++)
			{
				this.Graph[i][j] = noEdge();
			}
		}
	}
	
	
    /**
     * Returns the amount of knots of the graph
     * 
     * @return Amount of the knots  
     */
	@Override
	public int Size()
	{
		return Graph.length;
	}
	
    /**
     * Returns true if the graph is directed, false otherwise
     * 
     * @return True if the graph is directed, false otherwise
     */
	@Override
	public boolean isDirected()
	{
		return this.directed ? true : false; 
	}
	
	/**
	 * Returns the weight not existant edges
	 * 
	 * @return The weight not existant edges
	 */
	@Override
	public double noEdge()
	{
		return Double.POSITIVE_INFINITY;
	}
	
	/**
	 * Set the weight x of the edge i and j
     * 
	 * @param i First point
	 * @param j Second point
	 * @param x The weight of edge
	 */
	@Override
	public void setWeight(int i, int j, double x)
	{
		Graph[i][j] = x;
	}
	
	/**
	 * Returns the weight of edge i and j
	 * 
	 * @param i First point
	 * @param j Second point
	 * 
	 * @return The weight of the edge
	 */
	@Override
	public double getWeight(int i, int j)
	{
		return Graph[i][j];
	}
	
	/**
	 * Deletes the edge i and j
     * 
	 * @param i First point
	 * @param j Fecond point
	 */
	@Override
	public void deleteEdge(int i, int j)
	{
		Graph[i][j] = noEdge();
	}
	
	/**
	 * Returns true if i and j is an edge
	 * 
	 * @param i First point
	 * @param j Second point
	 * @return True if i and j is an edge
	 */
	@Override
	public boolean isEdge(int i, int j)
	{
		return (this.Graph[i][j] != Double.POSITIVE_INFINITY) ? true : false;
	}
}
