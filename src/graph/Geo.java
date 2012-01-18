package graph;


import graph.GeoGraph.PointNotExistInGraphException;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
            try {
                geoGraph.drawEdge(g, mst.getPrevNode(i), i);
            } catch (PointNotExistInGraphException ex) {
                Logger.getLogger(Geo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) 
    {
            // Create the geo object
        Geo geo = new Geo();
   
            // Creates a new JPanel
        JPanel panel = new JPanel(new BorderLayout());
            
            // and a new frame with a title
        JFrame frame = new JFrame("Minimum Spanning Tree - Hausarbeit Alorithmen 2012 - Lang");
            
            // The system close buttom should exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Create a custom close button
        JButton closeButton = new JButton("Close");
        
            // We need a string to output some information about the points in 
            // the graph
        String pointInfos = "<html>The graph consists of these points:<br />";
        
            // Compile the string 
        for (int i = 0; i < geo.points.length; i++)
        {
           pointInfos  += "P" + (i + 1) + ": X=" + geo.points[i].getX() + " and Y=" + geo.points[i].getY() + "<br />";
        }
        pointInfos += "</html>";
        
            // Create a new label with the string
        JLabel label = new JLabel(pointInfos);
        
            // Add the label to the panel
        panel.add(label);
        
            // Add the button to the panel
        panel.add(closeButton, BorderLayout.PAGE_END);
            
            // Add a Listener to the button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit( 0 );
            }
            
        });
        
            // Add the mimimum spanning tree to the frame
        frame.add(geo);
        
            // Add the other component inside the panel to the frame
        frame.add(panel, BorderLayout.PAGE_END);
        
            // Make a huge window
        frame.setSize(1000, 800);
            
            // which depends on you platform
        frame.setLocationByPlatform(true);
        
            // Let see 
        frame.setVisible(true);
        
            // Baby its dynamic baby. Move it!
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
       
        
    }
}
