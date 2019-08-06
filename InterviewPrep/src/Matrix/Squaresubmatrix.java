package Matrix;

//Maximum size square sub-matrix with all 1s

public class Squaresubmatrix {
	public int squaresubmatrix(int[][] matrix) {
		int[][] res = new int[3][3];
		int max = 0;
		
		// copy row to res matrix
		for(int i=0;i<3;i++) {
			res[i][0] = matrix[i][0];
		}
		
		// copy col to res matrix
		for(int j=0;j<3;j++) {
			res[0][j] = matrix[0][j];
		}
		
		for(int i=1;i<3;i++) {
			for(int j=1;j<3;j++) {
				if(matrix[i][j] == 1) {
					res[i][j] = min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1]) + 1;
					max = Math.max(max, res[i][j]);
				}
				else
				{
					res[i][j] = 0;
				}
			}
		}
		return max;
	}

	private int min(int i, int j, int k) {
		// TODO Auto-generated method stub
		return 0;
	}
}
