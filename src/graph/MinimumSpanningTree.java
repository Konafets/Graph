package graph;

import java.util.ArrayList;

/**
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering  
 */
public final class MinimumSpanningTree implements WeightedGraph
{
    private WeightedGraph weightedGraph;
    private final double maxWeight = Double.POSITIVE_INFINITY;
    private int[] prevNode; 
    private int size;
    private double[] distanceToPrevNode;
    
    public MinimumSpanningTree(WeightedGraph wg)
    {
        this.weightedGraph = wg;
        this.size = this.Size();
        this.distanceToPrevNode = new double[size];
        this.prevNode = new int[size];
        computeMinimumSpanningTree();
    }
    
    /**
     * Returns the amount of knots of the graph
     * 
     * @return int Amount of the knots  
     */
    @Override
    public int Size()
    {
        return this.weightedGraph.Size();
    }
	
    /**
     * Returns true if the graph is directed, false otherwise
     * 
     * @return boolean
     */
    @Override
    public boolean isDirected()
    {
        return this.weightedGraph.isDirected() ? true : false;
    }
	
	/**
	 * Returns the weight not existant edges
	 * 
	 * @return double
	 */
	@Override
    public double noEdge()
    {
        return this.maxWeight;
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
        return this.weightedGraph.getWeight(i, j);
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
    
    public int getPrevNode(int currentNode)
    {
        return this.prevNode[currentNode];
    }

    public double getDistanceToPrevNode(int currentNode)
    {
        return this.distanceToPrevNode[currentNode];
    }
    public void computeMinimumSpanningTree()
    {
        int nodeCounter, root;
        double w, m;
        boolean[] visitedNodes = new boolean[this.size];
        
            // Initialising all own arrays
        for (int i = 0; i < this.size; i++)
        {
            this.distanceToPrevNode[i] = this.maxWeight;
            visitedNodes[i] = false;
            this.prevNode[i] = -1;
        }
        
            // Startnode
        root = 0;
        visitedNodes[root] = true;
        this.distanceToPrevNode[root] = 0;
        nodeCounter = 1;
        
        while (nodeCounter < this.size)
        {
                // Update the candidates
            for (int i = 0; i < this.size; i++)
            {
                w = this.getWeight(root, i);
                if (!visitedNodes[i] && this.distanceToPrevNode[i] > w)
                {
                    this.distanceToPrevNode[i] = w;
                    this.prevNode[i] = root;
                }
            }
            
                // Search 
            m = this.maxWeight;
            for (int i = 0; i < this.size; i++)
            {
                if (!visitedNodes[i] && this.distanceToPrevNode[i] <= m)
                {
                    m = this.distanceToPrevNode[i];
                    root = i;
                }
            }
            
                // Add root to t
            visitedNodes[root] = true;
            nodeCounter++;
        }
    }   
}