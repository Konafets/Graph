/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;


/**
 *
 * @author sok
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
	 * @return int Amount of the knots  
	 */
	@Override
	public int Size()
	{
		return Graph.length;
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
	 * Returns the weight of no-existant edges
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
		Graph[i][j] = x;
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
		return Graph[i][j];
	}
	
	/**
	 * Deletes the edge i of j
	 * @param int i start knot
	 * @param int j end knot 
	 */
	@Override
	public void deleteEdge(int i, int j)
	{
		Graph[i][j] = noEdge();
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
		return (this.Graph[i][j] != Double.POSITIVE_INFINITY) ? true : false;
	}
}
