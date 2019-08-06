package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Topological {
	private int V;
	LinkedList<Integer> adj[];
	
	public Topological(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v,int w) { 
		adj[v].add(w); 
	}
	
	void topological() {
		boolean[] visited = new boolean[V];
		Stack stack = new Stack();
		
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				topologicalUtil(visited, stack, i);
			}
		}
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
	}

	private void topologicalUtil(boolean[] visited, Stack stack, int k) {
		visited[k] = true;
		Iterator<Integer> i = adj[k].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				topologicalUtil(visited, stack, n);
			}
		}
		stack.push(k);
	}
}
