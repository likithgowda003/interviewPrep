package Graph;

// DFS
// check all visited, else return false
// transpose
// make all nodes visited false
// DFS
// check all visited, else return false
public class StronglyConnected {

	Boolean isSC() 
    { 
        // Step 1: Mark all the vertices as not visited 
        // (For first DFS) 
        Boolean visited[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
  
        // Step 2: Do DFS traversal starting from first vertex. 
        DFSUtil(0, visited); 
  
        // If DFS traversal doesn't visit all vertices, then 
        // return false. 
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                return false; 
  
        // Step 3: Create a reversed graph 
        Graph gr = getTranspose(); 
  
        // Step 4: Mark all the vertices as not visited (For 
        // second DFS) 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
  
        // Step 5: Do DFS for reversed graph starting from 
        // first vertex. Staring Vertex must be same starting 
        // point of first DFS 
        gr.DFSUtil(0, visited); 
  
        // If all vertices are not visited in second DFS, then 
        // return false 
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                return false; 
  
        return true; 
    } 
	
	
	 void DFSUtil(int v,Boolean visited[]) 
	    { 
	        // Mark the current node as visited and print it 
	        visited[v] = true; 
	  
	        int n; 
	  
	        // Recur for all the vertices adjacent to this vertex 
	        Iterator<Integer> i = adj[v].iterator(); 
	        while (i.hasNext()) 
	        { 
	            n = i.next(); 
	            if (!visited[n]) 
	                DFSUtil(n,visited); 
	        } 
	    } 
	  
	 
	    // Function that returns transpose of this graph 
	    Graph getTranspose() 
	    { 
	        Graph g = new Graph(V); 
	        for (int v = 0; v < V; v++) 
	        { 
	            // Recur for all the vertices adjacent to this vertex 
	            Iterator<Integer> i = adj[v].listIterator(); 
	            while (i.hasNext()) 
	                g.adj[i.next()].add(v); 
	        } 
	        return g; 
	    } 
}
