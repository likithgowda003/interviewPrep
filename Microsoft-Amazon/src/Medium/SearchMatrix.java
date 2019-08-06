package Medium;

public class SearchMatrix {

	public static void main(String[] args) {
		int mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50} };
 
		System.out.println(search(mat, 33));
	}

	private static boolean search(int[][] mat, int k) {
		if(mat == null)
			return false;
		
		int i = 0;
		int j = mat[0].length-1;
		while(i<mat.length && j>=0) {
			if(mat[i][j] == k)
				return true;
			else if(mat[i][j] > k)
				j--;
			else
				i++;
		}
		return false;
	}


}
