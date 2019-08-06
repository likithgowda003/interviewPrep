package Medium;

public class ProductExceptItself {
	public static void main(String[] args) 
    {
        int arr[] = {10, 3, 5, 6, 2};
        int n = arr.length;
        System.out.println("The product array is : ");
        productArray(arr, n);
        //productArray1(arr, n);
    }

	

	private static void productArray(int[] arr, int n) {
		if(arr == null)
			return;
		
		int left[] = new int[n];
		int right[] = new int[n];
		int prod[] = new int[n];
		
		left[0] = 1;
		right[n-1] = 1;
		
		for(int i=1;i<n;i++) {
			left[i] = arr[i-1] * left[i-1];
		}
		
		for(int i=n-2;i>=0;i--) {
			right[i] = arr[i+1] * right[i+1];
		}
		
		for(int i=0;i<n;i++) {
			prod[i] = left[i] * right[i];
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(prod[i]);
		}
	}
	
	
	private static void productArray1(int[] arr, int n) {
		int temp = 1;
		int prod[] = new int[n];
		
		for(int i=0;i<n;i++) {
			prod[i] = 1;
		}
		
		for(int i=0;i<n;i++) {
			prod[i] = temp;
			temp = temp*arr[i];
		}
		
		temp = 1;
		for(int i=n-1;i>=0;i--) {
			prod[i] = prod[i] * temp;
			temp = temp * arr[i];
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(prod[i]);
		}
 	}
}
