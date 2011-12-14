/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author sok
 */
public class Geo
{
    
    public static void main(String[] args) {
		Point[] points = new Point[5];
        points[0] = new Point(2,3);
        points[1] = new Point(3,5);
        points[2] = new Point(4,4);
        points[3] = new Point(3,1);
        points[4] = new Point(3,3);
   
        GeoGraph geoGraph = new GeoGraph(points);
        System.out.println(geoGraph.getWeight(0, 3));
	} 
}
