package com.graph;

public class DirectedAcyclicGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(8);
		//System.out.println(g);
	    
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		g.addEdge(3, 7);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(4, 7);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		
		
//	    System.out.println(g);
	   System.out.println(g.getNode(2).getDirectlyLinkedNodes());
	   System.out.println("Shortest Path: " + g.getShortestPathDistance(g, new Node(0), new Node(7)));
	       
	}

}


