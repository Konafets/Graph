/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author sok
 */
public class DirectedGraph {
	public static void main(String[] args) {
		Graph directedGraph = new Graph(4, true);
		
		System.out.println(directedGraph.getWeight(0, 2));
		directedGraph.setWeight(0, 2, 8);
		System.out.println(directedGraph.getWeight(0, 2));
		System.out.println(directedGraph.isDirected());
	}
	
 }
