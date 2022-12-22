Author: Amber Lai
NetID: alai8
Student iD 31881586
Project 3 - Street Mapping 
Lab: MW 2-3:15pm

Synopsis: created a map that was able to find the shortest distance between two points and then map the two points on a map of all the nodes and edges from a given inputted file. 


Challenges: 
the hardest challenge i found from this was implementing dijksta's algorithm with the data types that i created. along with the gui, it was hard to implement at first since it has been so long using java graphics but i
was able to work past it and utilize a lot of online resouces. 

Files 
MapGUI.java - contains the methods to create a map that is resizeable and scaled based on the min and max longitude and latitude that is present in the nodes
map.java - this is the main file that contains the contents of reading in the files and from the terminal and determining what to do with it.
it also contains dijkstra's algorithm to compute the shortest path and methods to intialize and show the mapgui. 
Edge.java - data type that was the roads, allowed for different values of the road to be pulled. 
Node.java - data type that contained a linked list of edges associated to it so each node or intersection could keep track of the adjacent nodes 
Graph.java - I used a hashmap to create my graph of nodes using the string as the key and the node as the value. while the nodes were being added, it found 
the min and max latitude and longitude. When the edges were being added, it found the weight of all of the edges.


Time Complexity- 
the time complexity for finding the shortest path using dijkstra's is O(n^2) as it has a nested while loop that goes through all the nodes to finalize them. 
for the graph i decided to use a hashmap for easy access for each of the nodes

Inputs and outputs 
map.java file 
- dijkstras had the input of the graph created of the roads and intersections along with the start and end destination and an output of the final path in the form of an arraylist
- showmap method had the input of the graph that would show the map of the graph 
- printshortestpath had the input of the graph, start and end destination that printed out the final path from dijkstras


Helpful resources I utilized 
https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/
https://www.igismap.com/haversine-formula-calculate-geographic-distance-earth/