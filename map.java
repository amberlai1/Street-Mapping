/*Author:Amber Lai
 * Netid: alai8
 * Student id: 31881586
 * Project 3: Street Mapping
 * CSC 172
 * Lab: MW 2-3:15 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import javax.swing.JFrame;

public class map {
    static ArrayList<Node> finalpath = new ArrayList<>();
    public static void main (String[] args) {
        Boolean show = false;
        Boolean direct = false; 
        String start = "";
        String end = "";
      
    
       String input = args[0];
        Graph graph = new Graph();
        try  {
            Scanner scan = new Scanner(new File(input));
            while(scan.hasNextLine()){
                String curLine = scan.nextLine();
                String[] split = curLine.split("\t");
                
                if(split[0].equals("i")){
                    graph.addNode(new Node(split[1], Double.parseDouble(split[2]), Double.parseDouble(split[3])));
            
                }
                if(split[0].equals("r")){
                    graph.addEdge(new Edge(split[1], split[2], split[3],0));
                }
              
            }
        } catch (NumberFormatException | FileNotFoundException | IllegalStateException e) {
            
            e.printStackTrace();
        }
       
  
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("--show")){
                show = true;
            
            }
            if(args[i].equals( "--directions")){
                try {
                    start = args[i+1];
                    end = args[i+2];
                    direct = true; 
                    
                } catch (Exception e) {
                    System.out.println("There needs to be a start and end location!");
                }
            }
        }
        if(show == true && direct == true){
            printShortestpath(graph, start, end);
            showMap(graph); 
        }
        else if(show == true){
            showMap(graph); 
        }
        else if(direct == true){
            printShortestpath(graph, start, end);    
        }
    }

    public static ArrayList<Node> dijkstraAlgo(Graph g, String s, String d){
        Hashtable<String, Node> finalized = new Hashtable<>();
        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        Node neighNode; 
        Node start = g.gmap.get(s);
        start.distance = 0; 
        finalized.put(s, start);
        for(Edge e: start.edges){
            if(e.src.equals(s)){
                g.gmap.get(e.dest).addParent(start);
                g.gmap.get(e.dest).distance = e.weight;
            }
            if(e.dest.equals(s)){
                g.gmap.get(e.src).addParent(start);
                g.gmap.get(e.src).distance = e.weight;

            }
        }
        for(Node n: g.gmap.values()){
            pqueue.add(n);
        }
        Node curr = start;
        while(finalized.size() < g.gmap.size()){
            while(pqueue.isEmpty() != true && finalized.containsValue(curr)){
                curr = pqueue.poll();      
            }
            
            finalized.put(curr.name, curr);
            
            for(Edge e: curr.edges){
            
                if(e.src.equals(curr.name)){
                    neighNode = g.gmap.get(e.dest);
                }
                else{
                    neighNode = g.gmap.get(e.src);
                }

                if (!finalized.containsKey(neighNode.name) && curr.distance + e.weight < neighNode.distance) {
                    neighNode.distance = curr.distance + e.weight;
                    neighNode.addParent(curr);
                    pqueue.remove(neighNode);
                    pqueue.add(neighNode);
             
                } 
        }
    }
        curr = g.gmap.get(d);
        while(curr != null){
            finalpath.add(curr);
            curr = curr.parent;
        }
        Collections.reverse(finalpath);
        return finalpath; 
    }
   
    public static void printShortestpath(Graph g, String s, String d){
   
            System.out.println("The shortest path between:" + s + " and " + d + " is:" );
            for(Node n: dijkstraAlgo(g, s, d)){
                System.out.println(n + " ");
                
        }
        System.out.println("The total distance between " + s + " and " + d + " is " + g.gmap.get(d).distance + " " + "miles");
    }
    
    public static void showMap(Graph g){
        JFrame frame = new JFrame("Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MapGUI(g.eList, g.gmap, g.minlat, g.maxlat, g.minlong, g.maxlong));
        frame.pack();
        frame.setVisible(true);
    }


}