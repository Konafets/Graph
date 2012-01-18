package graph;

import java.awt.Graphics;
import javax.swing.JPanel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * This class implements a geo graph from given points
 * 
 * @author Finn Kondering 399083
 * @author Stefano Kowalke 485366
 */
public class GeoGraph extends JPanel implements WeightedGraph 
{
    public class PointNotExistInGraphException extends Exception 
    {
        public PointNotExistInGraphException()
        {
            
        }
        
        public PointNotExistInGraphException(String s)
        {
            super(s);
        }
    }
    
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
     * @return Amount of the knots  
     */
    @Override
    public int Size()
    {
        return this.graph.length;
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
        return this.graph[i].distanceTo(this.graph[j]);
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
     * Draws the points of a graph on the screen
     * 
     * @param gr The graphics object 
     */
    public void drawPoints(Graphics gr)
    {
        for (int i = 0; i < this.Size(); i++)
        {
            gr.fillOval(graph[i].getX() * 100, graph[i].getY() * 100, 6, 6);
        }
    }
    
    /**
     * Draws the edge of the between the given points on the screen
     * 
     * @param gr The graphics object 
     * @param i  First point
     * @param j  Second point
     * @throws PointNotExistInGraphException If indices are out of bound, means 
     *         that the particular Point doesn't exist.
     */
    public void drawEdge(Graphics gr, int i, int j) throws PointNotExistInGraphException
    {
        if ((i < 0) || (j >= this.Size()))
        {
            throw new PointNotExistInGraphException();
        }
        gr.drawLine(graph[i].getX() * 100, graph[i].getY() * 100, graph[j].getX() * 100, graph[j].getY() * 100);
    }

}
