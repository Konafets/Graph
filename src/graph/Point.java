/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author sok
 */
public class Point
{
    int x, y;
    
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
        
    }
    
    public double distanceTo(Point q)
    {
        return Math.sqrt(Math.abs(Math.pow(this.x - q.x, 2) + Math.pow(this.y - q.y,2)));
    }
    
}
