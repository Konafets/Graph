package graph;


import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author sok
 */
public class Geo extends JPanel
{
    Point[] points;
    
    public Geo()
    {
        init();
    }
    
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
           // calculates the exact size of the window
//      frame.pack();
        frame.setVisible(true);
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
       
        
	} 
}
