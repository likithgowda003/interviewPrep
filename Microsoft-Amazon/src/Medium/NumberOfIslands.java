package Medium;

public class NumberOfIslands {
	 static final int ROW = 5, COL = 5;
	 
	int countIslands(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];
 
 
        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j]==1 && !visited[i][j]) // If a cell with
                {                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }
 
        return count;
    }

	private void DFS(int[][] M, int i, int j, boolean[][] visited) {
		// These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
 
        // Mark this cell as visited
        visited[i][j] = true;
        
        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, i + rowNbr[k], j + colNbr[k], visited) )
                DFS(M, i + rowNbr[k], j + colNbr[k], visited);
 
	}

	private boolean isSafe(int[][] m, int i, int j, boolean[][] visited) {
		// TODO Auto-generated method stub
		return (i>=0 && i<ROW && j>=0 && j>=COL && !visited[i][j] && m[i][j]==1);
	}
}
