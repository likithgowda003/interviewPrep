package Graph;

// https://www.techiedelight.com/find-shortest-path-in-maze/
public class Maze {
	public boolean solvemaze(int[][] matrix) {
		int sol[][] = {{0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0}
	        };
		
		if(helper(matrix,0,0,sol))
			return true;
		return false;
		
	}

	private boolean helper(int[][] matrix, int i, int j, int[][] sol) {
		// if (i,j is goal) return true
		if(i == matrix.length-1 && j == matrix[0].length-1) {
			sol[i][j] = 1;
			return true;
		}
		
		if(isSafe(matrix, i, j)) {
			sol[i][j] = 1;
			
			/* Move forward in x direction */
            if (helper(matrix, i + 1, j, sol))
                return true;
 
            /* If moving in x direction doesn't give
               solution then  Move down in y direction */
            if (helper(matrix, i, j + 1, sol))
                return true;
 
            /* If none of the above movements works then
               BACKTRACK: unmark x,y as part of solution
               path */
            sol[i][j] = 0;
            return false;
 
		}
		return false;
		
	}

	private boolean isSafe(int[][] matrix, int i, int j) {
		return i>=0 && i<matrix.length && j>=0 && j<matrix[0].length && matrix[i][j] == 1;
	}
}
