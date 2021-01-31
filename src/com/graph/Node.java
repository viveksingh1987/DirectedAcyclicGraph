package com.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class of Node entity Implements GraphNode
 * 
 * @author vivek
 *
 */
public class Node implements GraphNode {

	@Override
	public Set<GraphNode> getDirectlyLinkedNodes() {
		Set<GraphNode> nodeSet = new HashSet<GraphNode>();
		for (int i = 0; i < getConnectedNodes().size(); i++) {
			nodeSet.add(new Node(getConnectedNodes().get(i)));
		}
		return nodeSet;
	}

	/**
	 * Node Id
	 */
	private int id;
	
	/**
	 * Connected Nodes
	 */
	private List<Integer> connectedNodes;

	/**
	 * Constructor
	 * @param id
	 */
	public Node(int id) {
		super();
		this.id = id;
		this.connectedNodes = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getConnectedNodes() {
		return connectedNodes;
	}

	public void addConnectedNodes(int e) {
		this.connectedNodes.add(e);
	}

	public void setConnectedNodes(List<Integer> connectedNodes) {
		this.connectedNodes = connectedNodes;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", connectedNodes=" + connectedNodes + "]";
	}

}
