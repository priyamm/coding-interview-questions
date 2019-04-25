/**
 * 
 */
package com.priyam.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author prigupta8
 *
 */
public class DFSCyclic {
	
	private final int V;
	private final List<List<Integer>> adj;
	
	/**
	 * 
	 */
	public DFSCyclic(int V) {
		this.V = V;
		this.adj = new ArrayList<>(V);
		
		for(int i = 0; i < V ; i ++) {
			adj.add(new LinkedList<>());
		}
	}
	
	 private void addEdge(int source, int dest) { 
	        adj.get(source).add(dest); 
	    } 
	
	private Boolean detectCycle() {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		
		for(int i = 0; i<V ; i ++) {
			if(DFSCycleUtil(i, visited, recStack))
				return true;
		}
		return false;
	}
	
	private Boolean DFSCycleUtil(int i, boolean[] visited, boolean[] recStack) {
		
		if(recStack[i])
			return true;
		
		
		// Beacause its not present in the recStack but visited is true hence we dont need to treverse the adjacent of that node again.
		if(visited[i])
			return false;
		
		
		visited[i] = true;
		recStack[i] = true;
		
		
		for(Integer node : adj.get(i)) {
			if(DFSCycleUtil(node, visited, recStack))
				return true;
		}
		
		recStack[i] = false;
		return false;
	}
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		DFSCyclic graph = new DFSCyclic(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.addEdge(1, 2);
		
		
		System.out.println("Result : " + graph.detectCycle());
	}
	
	

}
