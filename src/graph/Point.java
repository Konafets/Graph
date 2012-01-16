package graph;

/**
 * 
 * @author Stefano Kowalke 485366
 * @author Finn Kondering  
 */
public class Point
{
    private int x, y;
    
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
        
    }
    
    public double distanceTo(Point q)
    {
        return Math.sqrt(Math.abs(Math.pow(this.x - q.x, 2) + Math.pow(this.y - q.y,2)));
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
}
