package Matrix;

public class NullifyMatrix {

	public static void main(String[] args) {
		int mat[][] = {{0, 1, 1, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 1}};
                 
        System.out.println("Input Matrix :");
        printMatrix(mat);
             
        modifyMatrix(mat);
             
        System.out.println("Matrix After Modification :");
        printMatrix(mat);

	}
	
	public static void modifyMatrix(int mat[][]){
        
        // variables to check if there are any 0 
        // in first row and column
        boolean row_flag = false;
        boolean col_flag = false;
                 
        // updating the first row and col if 0
        // is encountered
        for (int i = 0; i < mat.length; i++ ){
                for (int j = 0; j < mat[0].length; j++){
                        if (i == 0 && mat[i][j] == 0)
                            row_flag = true;
                         
                        if (j == 0 && mat[i][j] == 0)
                            col_flag = true;
                         
                        if (mat[i][j] == 0){
                             
                            mat[0][j] = 0;
                            mat[i][0] = 0;
                        }
                         
                    }
                }
                 
        // Modify the input matrix mat[] using the 
        // first row and first column of Matrix mat
        for (int i = 1; i < mat.length; i ++){
                for (int j = 1; j < mat[0].length; j ++){
                         
                    if (mat[0][j] == 0 || mat[i][0] == 0){
                            mat[i][j] = 0;
                        }
                    }
                }
                 
        // modify first row if there was any 0
        if (row_flag == true){
            for (int i = 0; i < mat[0].length; i++){
                        mat[0][i] = 0;
                    }
                }
                 
        // modify first col if there was any 0
        if (col_flag == true){
            for (int i = 0; i < mat.length; i ++){
                        mat[i][0] = 0;
            }
        }
    }
	
	public static void printMatrix(int mat[][]){
        for (int i = 0; i < mat.length; i ++){
            for (int j = 0; j < mat[0].length; j ++){
                System.out.print( mat[i][j] );
            }
                System.out.println("");
        }
    }

}
