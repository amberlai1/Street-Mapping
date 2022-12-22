/*Author:Amber Lai
 * Netid: alai8
 * Student id: 31881586
 * Project 3: Street Mapping
 * CSC 172
 * Lab: MW 2-3:15 
 */

import java.util.*;
public class Graph { 
    HashMap<String, Node> gmap;
    ArrayList<Edge> eList = new ArrayList<Edge>(); 
    double minlat;
    double minlong;
    double maxlat;
    double maxlong; 
    double srclat;
    double srclong;
    double destlat;
    double destlong;

    //Graph Constructor
    public Graph(){
        gmap = new HashMap<String, Node>();
    }

    public void addNode(Node node){
        gmap.put(node.name, node);
        if(gmap.size() == 1){
            minlat = node.lat;
            maxlat = node.lat;
            minlong = node.longit;
            maxlong = node.longit;
        }
        if (node.lat < minlat){
            minlat = node.lat;
        }
        if (node.longit < minlong){
            minlong = node.longit;
        }
        if (node.lat > maxlat){
            maxlat = node.lat;
        }
        if (node.longit > maxlong){
            maxlong = node.longit;
        }
    }

    public void addEdge(Edge edge){
        
        if(gmap.containsKey(edge.src)){ // gets the start of the edge and gets latitude and longitude of the node 
            srclat = gmap.get(edge.src).lat;
            srclong = gmap.get(edge.src).longit;
        }
        if(gmap.containsKey(edge.dest)){ // gets the end of the edge and gets latitude and longitude of the node 
            destlat = gmap.get(edge.dest).lat;
            destlong = gmap.get(edge.dest).longit;
        }
       
        edge.weight = haversine(srclat, srclong, destlat, destlong);  // adds the weight to the edge 
        gmap.get(edge.src).edges.add(edge);
        gmap.get(edge.dest).edges.add(edge);
        eList.add(edge);
    }
   
     // got from https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/
    
    public static double haversine(double lat1, double lon1, double lat2, double lon2){
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                Math.cos(lat1) *
                Math.cos(lat2);
        double rad = 3958.756;  // get in miles  https://www.igismap.com/haversine-formula-calculate-geographic-distance-earth/
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }
}



