package Matrix;

public class Search2DMatrix {
	public static void main(String[] args) {
        int mat[][] = { {10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50} };
         
        if(search(mat,29))
        		System.out.println("Target found");
        else
        		System.out.println("Target not found");
    }

	private static boolean search(int[][] matrix, int target) {
		int i = 0;
        int j = matrix[0].length-1;
        
        if(matrix.length == 0 && matrix[0].length == 0)
            return false;
        
        while(i<matrix.length && j>=0){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target){
                i++;
            }
            else if(matrix[i][j] > target){
                j--;
            }
        }
        return false;
    }
}
