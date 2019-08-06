package Graph;

// no of unique paths from top left to bottom right corner
// can move right and bottom
public class SrcToDestNoOfPaths {

	public static void main(String[] args) {
		int row = 7,col = 3;
		System.out.println(unique(row,col));
	}

	private static int unique(int row, int col) {
		int[][] mat = new int[row][col];
		
		for(int i=0;i<row;i++) {
			mat[i][0] = 1;
		}
		
		for(int i=0;i<col;i++) {
			mat[0][i] = 1;
		}
		
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				mat[i][j] = mat[i-1][j] + mat[i][j-1];
			}
		}
		return mat[row-1][col-1];
	}

}
