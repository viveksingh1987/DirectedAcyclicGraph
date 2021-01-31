package com.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Graph Services
 * 
 * @author vivek
 *
 */
public class GraphServices {

	final static int INFINITE = Integer.MAX_VALUE;
	final static int UNDEFINED = -1;

	public GraphServices() {
		super();
	}

	/**
	 * Method to get the shortest Path between the nodes
	 * @param graph
	 * @param source
	 * @return
	 */
	public static Object[] shortestPathByBFS(Graph graph, int source) {

		int graphSize = graph.getSize();
		int[] distances = new int[graphSize];
		int[] predecessors = new int[graphSize];
		boolean[] visited = new boolean[graphSize];
		Queue<Integer> queue = new ArrayDeque<>();

		for (int v = 0; v < graphSize; v++) {
			distances[v] = INFINITE;
			predecessors[v] = UNDEFINED;
		}

		distances[source] = 0;
		visited[source] = true;
		queue.offer(source);

		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (int v : graph.getNode(u).getConnectedNodes()) {
				if (!visited[v]) {
					visited[v] = true;
					distances[v] = distances[u] + 1;
					predecessors[v] = u;
					queue.offer(v);
				}
			}
		}

		return new Object[] { distances, predecessors };
	}

	/**
	 *  
	 * @param paths
	 */
	public void printShortestPathResult(Object[] paths) {
		int[] distancesFromSource = (int[]) paths[0];
		int[] predecessorsOfSource = (int[]) paths[1];

		System.out.println("Node \t Distance from source \t Route from source");

		for (int v = 0; v < distancesFromSource.length; v++) {
			if (distancesFromSource[v] == INFINITE) {
				System.out.printf("%-10s%-24s%s%s", v, "N/A", "N/A", System.lineSeparator());
				continue;
			}

			Deque<Integer> route = new ArrayDeque<>();
			route.push(v);
			int u = predecessorsOfSource[v];
			while (u >= 0) {
				route.push(u);
				u = predecessorsOfSource[u];
			}

			System.out.printf("%-10d%-28d%s%s", v, distancesFromSource[v], route.toString(), System.lineSeparator());
		}
	}

	/**
	 * Method to return the shortest path between two nodes
	 * @param paths
	 * @param dest
	 * @return
	 */
	public int getShortestDistance(Object[] paths, int dest) {
		int[] distancesFromSource = (int[]) paths[0];
		int[] predecessorsOfSource = (int[]) paths[1];

		if (distancesFromSource[dest] == INFINITE) {
			System.out.println("Sorry No Route Found");
			return -1;
		}

		Deque<Integer> route = new ArrayDeque<>();
		route.push(dest);
		int u = predecessorsOfSource[dest];
		while (u >= 0) {
			route.push(u);
			u = predecessorsOfSource[u];
		}

		System.out.println("Minimum Distance:  " + distancesFromSource[dest] + " | Route: " + route.toString());
		return distancesFromSource[dest];
	}

}
