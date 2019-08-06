package Graph;

public class SudokuSolver {
	int row=0, col=0;
	public boolean sudokusolver(int[][] grid) {
		
		// if all positions are assigned, success
		if(!FindUnnassignedLocation(grid))
			return true;
		
		for(int i=0;i<=9;i++) {
			if(isSafe(grid,row, col, i)) {
				grid[row][col] = i;
				
				if(sudokusolver(grid))
					return true;
				
				grid[row][col] = -1;
			}
		}		
		return false;
	}


	private boolean FindUnnassignedLocation(int[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == -1)
					row = i;
					col = j;
					return true;
			}
		}
		return false;
	}
	
	private boolean isSafe(int[][] grid, int row, int col, int num) {
		return !UsedInRow(grid,row,num) && !UsedInCol(grid,col,num) && !UsedInBox(grid,row,col,num);
	}


	private boolean UsedInRow(int[][] grid, int row, int num) {
		for(int i=0;i<grid[0].length;i++) {
			if(grid[row][i] == num)
				return true;
		}
		return false;
	}
	
	private boolean UsedInCol(int[][] grid, int col, int num) {
		for(int i=0;i<grid.length;i++) {
			if(grid[col][i] == num)
				return true;
		}
		return false;
	}
	
	private boolean UsedInBox(int[][] grid, int row, int col, int num) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(grid[row+i][col+j] == num)
					return true;
			}
		}
		return false;
	}
}
