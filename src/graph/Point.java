package graph;

/**
 * This class implements an point with two coordinates in a 2D coordination system
 * 
 * @author Finn Kondering 399083
 * @author Stefano Kowalke 485366
 */
public class Point
{
    /**
     * The X coordinate of the point
     */
    private int x;
    
    /**
     * The Y coordinate of the point
     */
    private int y;
    
    /**
     * The constructor
     * 
     * @param x Value of the x coordinate
     * @param y Value of the y coordinate
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
        
    }
    
    /**
     * Calculates the distance (weight) from the instance to the given point
     * 
     * @param q The second point
     * @return The distance between the two points
     */
    public double distanceTo(Point q)
    {
        return Math.sqrt(Math.abs(Math.pow(this.x - q.x, 2) + Math.pow(this.y - q.y,2)));
    }
    
    /**
     * Returns the value of the X coordinate
     * 
     * @return The value of the X coordinate
     */
    public int getX()
    {
        return this.x;
    }
    
    /**
     * Returns the value of the Y coordinate
     * 
     * @return The value of the Y coordinate
     */
    public int getY()
    {
        return this.y;
    }
    
}
