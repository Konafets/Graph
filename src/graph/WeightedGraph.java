/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author sok
 */
public interface WeightedGraph 
{
	/**
	 * Returns the amount of knots of the graph
	 * 
	 * @return int Amount of the knots  
	 */
	public int size();
	
	/**
	 * Returns true if the graph is directed, false otherwise
	 * 
	 * @return boolean
	 */
	public boolean isDirected();
	
	/**
	 * Returns the weight not existant edges
	 * 
	 * @return double
	 */
	public double noEdge();
	
	/**
	 * Set the weight x of the knots i and j
	 * 
	 * @param int i 
	 * @param int j
	 * @param double x  the weight of knots
	 */
	public void setWeight(int i, int j, double x);
	
	/**
	 * Returns the weight of edge i and j
	 * 
	 * @param int i start knot
	 * @param int j end knot
	 * 
	 * @return double the weight of the edge
	 */
	public double getWeight(int i, int j);
	
	/**
	 * Deletes the edge i of j
	 * @param int i start knot
	 * @param int j end knot 
	 */
	public void deleteEdge(int i, int j);
	
	/**
	 * Returns true if i and j is an edge
	 * 
	 * @param int i start knot
	 * @param int j end knot
	 * @return boolean
	 */
	public boolean isEdge(int i, int j);
}
