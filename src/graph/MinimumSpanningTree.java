package graph;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * This class implements the calculation of a minimum spanning tree from given graph
 * 
 * @author Finn Kondering 399083
 * @author Stefano Kowalke 485366
 */
public final class MinimumSpanningTree implements WeightedGraph
{
    /**
     * A representation of a wheighted graph. Could every type of graph if
     * it implements the interface of WeightedGraph.
     */
    private WeightedGraph weightedGraph;
    
    /**
     * The maximum weight of a edge.
     */
    private final double maxWeight = Double.POSITIVE_INFINITY;
    
    /**
     * This array will contain the minimum spanning tree. 
     * From last node to first node
     */
    private int[] prevNode; 
    
    /**
     * The size (amount of nodes) of the graph
     */
    private int size;
    
    /**
     * This array contains the distance between the nodes of the minimum spanning tree
     * From last node to first node
     */
    private double[] distanceToPrevNode;
    
    /**
     * The constructor
     * 
     * @param wg A graph
     */
    public MinimumSpanningTree(WeightedGraph wg)
    {
        this.weightedGraph = wg;
        this.size = wg.Size();
        this.distanceToPrevNode = new double[size];
        this.prevNode = new int[size];
        computeMinimumSpanningTree();
    }
    
    /**
     * Returns the amount of knots of the graph
     * 
     * @return Amount of the knots  
     */
    @Override
    public int Size()
    {
        int result = 0;
        for (int i = distanceToPrevNode.length - 1; i > 0; i--)
        {
            
                result += distanceToPrevNode[i];
            
        }
        return result;
    }

    /**
     * Returns true if the graph is directed, false otherwise
     * 
     * @return True if the graph is directed, false otherwise
     */
    @Override
    public boolean isDirected()
    {
        return this.weightedGraph.isDirected() ? true : false;
    }

    /**
     * Returns the weight not existant edges
     * 
     * @return The weight not existant edges
     */
    @Override
    public double noEdge()
    {
        return this.maxWeight;
    }

    /**
     * Set the weight x of the edge i and j
     * 
     * @param i First point
     * @param j Second point
     * @param x The weight of edge
     * @throws NotImplementedException This method will not implemented
     */
    @Override
    public void setWeight(int i, int j, double x)
    {
        throw new NotImplementedException();
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
        return this.weightedGraph.getWeight(i, j);
    }

    
    /**
     * Deletes the edge i and j
     * 
     * @param i First point
     * @param j Fecond point
     * @throws NotImplementedException This method will not implemented
     */
    @Override
    public void deleteEdge(int i, int j)
    {
        throw new NotImplementedException();   
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
        boolean result = true;
        
        if (this.getWeight(i, j) == this.noEdge())
        {
            result = false;
        }
        
        return result;
    }
    
    /**
     * Returns the previous node of the passed current node
     * 
     * @param currentNode The current node
     * @return The previous node of the passed current node
     */
    public int getPrevNode(int currentNode)
    {
        return this.prevNode[currentNode];
    }

    /**
     * Returns the distance (weight) from the passed current node to the the 
     * previous node
     * 
     * @param currentNode The current node
     * @return The distance from passed node to prev node
     */
    public double getDistanceToPrevNode(int currentNode)
    {
        return this.distanceToPrevNode[currentNode];
    }
    
    /**
     * Computes the minimum spanning tree
     * 
     * First the method calculates the distances between all nodes and 
     * stores the nodes with minimim distance in array prevNode.
     */
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