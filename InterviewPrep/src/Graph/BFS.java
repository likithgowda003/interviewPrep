package Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	private int V;
	LinkedList<Integer> adj[];
	
	public BFS(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void BFS(int src) {
		LinkedList<Integer> q = new LinkedList();
		boolean visited[] = new boolean[V];
		q.add(src);
		visited[src] = true;
		
		while(!q.isEmpty()) {
			int s = q.poll();
			System.out.println(s);
			
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}
	}
	
	public static void main(String args[])
    {
        BFS g = new BFS(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
    }
	
}
