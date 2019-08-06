package Arrays;

public class RepeatingAndMissingNumber {
	
	public void find(int[] arr) {
		int n = arr.length;
		
		// repeating element
		for(int i=0;i<n;i++) {
			int val = Math.abs(arr[i]);
			if(arr[i] > 0) {
				arr[val-1] = -arr[val-1]; 
			}
			else
				System.out.println(val);
		}
		
		// missing element
		for(int i=0;i<n;i++) {
			if(arr[i] > 0) {
				System.out.println(i+1);
			}
		}
	}
}
