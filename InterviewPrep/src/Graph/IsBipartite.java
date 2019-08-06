package Graph;

import java.util.LinkedList;

public class IsBipartite {
	
	public static int V =4; 
    
    // This function returns true if graph G[V][V]  
    // contains odd cycle, else false 
    public static boolean containsOdd(int G[][], int src) 
    { 
        // Create a color array to store colors assigned  
        // to all vertices. Vertex number is used as  
        // index in this array. The value '-1' of  
        // colorArr[i] is used to indicate that no color 
        // is assigned to vertex 'i'.  The value 1 is  
        // used to indicate first color is assigned and 
        // value 0 indicates second color is assigned. 
        int colorArr[] = new int[V]; 
        for (int i = 0; i < V; ++i) 
            colorArr[i] = -1; 
        
        // Assign first color to source 
        colorArr[src] = 1; 
        
        // Create a queue (FIFO) of vertex numbers and  
        // enqueue source vertex for BFS traversal 
        LinkedList<Integer> q = new LinkedList<Integer>(); 
        q.add(src); 
        
        // Run while there are vertices in queue  
        // (Similar to BFS) 
        while (!q.isEmpty()) 
        { 
            // Dequeue a vertex from queue  
            int u = q.peek(); 
            q.pop(); 
        
            // Return true if there is a self-loop  
            if (G[u][u] == 1) 
               return true;   
        
            // Find all non-colored adjacent vertices 
            for (int v = 0; v < V; ++v) 
            { 
                // An edge from u to v exists and  
                // destination v is not colored 
                if (G[u][v] == 1 && colorArr[v] == -1) 
                { 
                    // Assign alternate color to this  
                    // adjacent v of u 
                    colorArr[v] = 1 - colorArr[u]; 
                    q.push(v); 
                } 
        
                // An edge from u to v exists and  
                // destination v is colored with same  
                // color as u 
                else if (G[u][v] == 1 && colorArr[v] == 
                                          colorArr[u]) 
                    return true; 
            } 
        } 
        
        // If we reach here, then all adjacent  
        // vertices can be colored with alternate 
        // color 
        return false; 
    } 
}
