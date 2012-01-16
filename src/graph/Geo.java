package graph;


import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.*;

/**
 * This class contains the main method and the drawing component.
 * It set up the points, the graph and calculates the minimum spanning tree,
 * after that it draws it on the screen.
 * 
 * @author Finn Kondering 399083
 * @author Stefano Kowalke 485366
 */
public class Geo extends JPanel
{
    /**
     * An array of points
     */
    Point[] points;
    
    /**
     * The constructor
     */
    public Geo()
    {
        init();
    }
    
    /**
     * Initialize some points
     */
    private void init()
    {
            // Create some points
        points = new Point[5];
        points[0] = new Point(1,1);
        points[1] = new Point(2,1);
        points[2] = new Point(1,2);
        points[3] = new Point(5,5);
        points[4] = new Point(3,3);
    }  
    
    /**
     * This methods override the method from JPanel to draw own things on the screen
     * 
     * @param g A Graphics object 
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        GeoGraph geoGraph = new GeoGraph(this.points);
        MinimumSpanningTree mst = new MinimumSpanningTree(geoGraph);
        geoGraph.drawPoints(g);
        for (int i = geoGraph.Size() - 1; i > 0; i--)
        {
            geoGraph.drawEdge(g, mst.getPrevNode(i), i);
        }
    }
    
    public static void main(String[] args) 
    {
        Geo geo = new Geo();
   
        JFrame frame = new JFrame("Minimum Spanning Tree - Alorithmen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("<html><h1>Hausarbeit Algorithmen (Lang) - Graphen</h1><br></html>");
        frame.add(label1);
        frame.add(geo);
        frame.setSize(800, 600);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
       
        
	} 
}
