/*Author:Amber Lai
 * Netid: alai8
 * Student id: 31881586
 * Project 3: Street Mapping
 * CSC 172
 * Lab: MW 2-3:15 
 */

//class to store edges of the weighted graph
public class Edge implements Comparable<Edge> { 
    String id, src, dest;
    double weight;
    Edge(String id, String src, String dest, double weight) {
        this.id = id;
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public String returnID(){
        return id;
    }

    @Override
    public String toString() {
        return String.format("Edge: src = %s, dest = %s, weight = %.5f", this.src, this.dest, this.weight);
    }
    @Override
    public int compareTo(Edge o) {
        if (this.weight - o.weight < 0) {
            return -1;
        } else if (this.weight - o.weight > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}