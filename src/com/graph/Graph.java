package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Directed Acyclic Graph Class
 * 
 * @author vivek
 *
 */
public class Graph {
	/**
	 * List of Nodes
	 */
	private List<Node> nodes;
	
	/**
	 * Method to print the shortest route between source node and destination node
	 * @param g
	 * @param startNode
	 * @param finishNode
	 * @return
	 */
	public static int getShortestPathDistance(Graph g, Node startNode, Node finishNode) {
		// implement this
		
		GraphServices service = new GraphServices();
		System.out.println("Shortest route between nodes | StartNode: " + startNode.getId() + " | FinishNode: "
				+ finishNode.getId());
		Object[] paths = service.shortestPathByBFS(g, startNode.getId());
		service.printShortestPathResult(paths);
		return service.getShortestDistance(paths, finishNode.getId());
	}
	
	/**
	 * Method to add Edge between given nodes
	 * @param source
	 * @param dest
	 */
	public void addEdge(int source, int dest) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getId() == source) {
				nodes.get(i).addConnectedNodes(dest);
			}
		}

	}
	
	/**
	 * Method to search Graph for given NodeId
	 * @param searchId
	 * @return
	 */
	public Node getNode(int searchId) {
		for (Node node : this.getNodes()) {
			if (node.getId() == searchId) {
				return node;
			}
		}
		return null;
	}
	
	/**
	 * Constructor
	 * @param size
	 */
	public Graph(int size) {
		super();
		nodes = new ArrayList<Node>();
		for (int i = 0; i < size; i++) {
			this.addNode(new Node(i));
		}
	}
	
	/**
	 * Default Constructor
	 */
	public Graph() {
		this.nodes = new ArrayList<>();
	}

	/**
	 * 
	 * @param e
	 */
	public void addNode(Node e) {
		this.nodes.add(e);
	}

	/**
	 * 
	 * @return
	 */
	public List<Node> getNodes() {
		return nodes;
	}
	/**
	 * 
	 * @return
	 */
	public int getSize() {
		return this.nodes.size();
	}

	@Override
	public String toString() {
		return "DirectedAcyclicGraph{" + "nodes=" + nodes + "}";
	}

}
