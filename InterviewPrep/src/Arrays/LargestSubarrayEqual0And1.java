package Arrays;

// arr consists  of 0's and 1's
// consider all zeros as -1 and find sum starting from a point.
// once sum equal 0, get length from starting point
public class LargestSubarrayEqual0And1 {
	
	public int largestsubarray(int[] arr) {
		int sum = 0;
		int max_length = -1;

		// Pick a starting point as i 
		for(int i=0;i<arr.length-1;i++) {
			sum = (arr[i] == 0) ? -1 : 1;
			
			//Consider all subarrays starting from i 
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j] == 0)
					sum = sum - 1;
				else
					sum = sum + 1;
				
				// once sum equal 0, get length from starting point
				if(sum == 0 && max_length < j-i+1) {
					max_length = j-i+1;
				}
			}
		}
		return max_length;
	}
	
	
	
	
	
	
	
}


