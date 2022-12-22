/*Author:Amber Lai
 * Netid: alai8
 * Student id: 31881586
 * Project 3: Street Mapping
 * CSC 172
 * Lab: MW 2-3:15 
 */
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;


public class MapGUI extends JPanel{
	
	public static ArrayList<Edge> roads;
	public static HashMap<String, Node> intersectionMap;
	public static boolean thickLines = false;
	
	public static double minLat, minLong, maxLat, maxLong;
	public static double xScale, yScale;
	
	public MapGUI(ArrayList<Edge> roads, HashMap<String, Node> intersectMap, double minimumLat, double maximumLat, double minimumLong, double maximumLong) {
		
		MapGUI.roads = roads;
		MapGUI.intersectionMap = intersectMap;
		
		minLat = minimumLat;
		maxLat = maximumLat;
		minLong = minimumLong;
		maxLong = maximumLong;
		
		setPreferredSize(new Dimension(800, 800));
		
	}
	
	public void paintComponent(Graphics page) {
		Graphics2D page2 = (Graphics2D) page;
		super.paintComponent(page2);
		
		page2.setColor(Color.BLACK);
		
		if(thickLines) {
			page2.setStroke(new BasicStroke(3));
		}
		
		//scale
		xScale = this.getWidth() / (maxLong - minLong);
		yScale = this.getHeight() / (maxLat - minLat);
		
		Node int1, int2;
		
		double x1, y1, x2, y2;
		
	//graphs the roads
		for(Edge r : roads) {
			
			scale();
			
			int1 = intersectionMap.get(r.src);
			int2 = intersectionMap.get(r.dest);
			
			x1 = int1.longit; 
			y1 = int1.lat;
			x2 = int2.longit;
			y2 = int2.lat;
		
			page2.draw(new Line2D.Double((x1-minLong) * xScale, getHeight() - ((y1 - minLat) * yScale), 
					(x2-minLong) * xScale, getHeight() - ((y2 - minLat) * yScale)));
			
		}
		
		//shortest path drawing 
		if(map.finalpath != null) {
			
			page2.setColor(Color.RED);
			
			for(int i = 0; i < map.finalpath.size() - 1; i++) {
				
				x1 = map.finalpath.get(i).longit;
				y1 = map.finalpath.get(i).lat;
				x2 = map.finalpath.get(i+1).longit;
				y2 = map.finalpath.get(i+1).lat;
				
				page2.draw(new Line2D.Double((x1-minLong) * xScale, getHeight() - ((y1 - minLat) * yScale), 
						(x2-minLong) * xScale, getHeight() - ((y2 - minLat) * yScale)));

			}
			
			
		}
    }
	//rescales the graph 
	public void scale() {
		xScale = this.getWidth() / (maxLong - minLong);
		yScale = this.getHeight() / (maxLat - minLat);

}
}


