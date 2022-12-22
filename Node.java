/*Author:Amber Lai
 * Netid: alai8
 * Student id: 31881586
 * Project 3: Street Mapping
 * CSC 172
 * Lab: MW 2-3:15 
 */
import java.util.*;

//class to store nodes of weighted graph 
public class Node implements Comparable<Node>{ 
    String name;
    double lat;
    double longit;
    double distance;
    LinkedList<Edge> edges;
    Node parent;
    boolean visited;
   // String weight;
    Node(String name, double lat, double longit)  {
        this.name = name;
        this.lat = lat;
        this.longit = longit;
        this.distance = Double.MAX_VALUE;
        this.edges = new LinkedList<Edge>();
        this.parent = null; 
        this.visited = false;
        //this.weight = weight;
    }
    public String returnName(){
        return name;
    }
    public double returnlat(){
        return lat;
    }
    public double returnlong(){
        return longit;
    }
    public void addParent(Node p){
        parent = p;
    }

    @Override
    public int compareTo(Node o) {
        if (this.distance - o.distance < 0) {
            return -1;
        } else if (this.distance - o.distance > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format(this.name);
    }
}

