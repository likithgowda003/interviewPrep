package Arrays;

// https://www.programcreek.com/2014/05/leetcode-minimum-size-subarray-sum-java/
// Given an array of n positive integers and a positive integer s, find the minimal length 
//of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
public class MinSizeSubarraySum {
	
	// use the sliding window approach. have two pointers and move it according to sum
	public int minSizeSubarraySum(int a[], int target) {
		int i=0;
		int j=0;
		int sum=0;
		int min_len = Integer.MAX_VALUE;
		
		while(j<a.length) {
			if(sum < target) {
				sum = sum + a[j];
				j++;
			}
			else {
				min_len = Math.min(min_len, j-i);
				
				if(i == j-1)
					return 1;
				
				sum = sum - a[i];
				i++;
			}
		}
		
		while(sum > target) {
			min_len = Math.min(min_len, j-i);
			sum = sum - a[i];
			i++;
		}
		
		return min_len == Integer.MAX_VALUE ? 0 : min_len;
	}
}
