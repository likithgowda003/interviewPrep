package Medium;

// transpose
// reverse columns
public class RotateImage {
	
	static void rotate90(int arr[][])
    {
        transpose(arr);
        reverseColumns(arr);
    }

	private static void transpose(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}

	private static void reverseColumns(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0,k=arr.length-1;j<k;j++,k--) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][k];
				arr[i][k] = temp;
			}
		}
	}
}
