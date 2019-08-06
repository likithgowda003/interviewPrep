package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	private int V;
	LinkedList<Integer> adj[];
	
	public DFS(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void DFS(int src) {
		boolean visited[] = new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				DFSUtil(i, visited);
			}
		}
	}

	private void DFSUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.println(s);
		Iterator<Integer> i = adj[s].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	
	public static void main(String args[])
    {
        DFS g = new DFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
    }
}
