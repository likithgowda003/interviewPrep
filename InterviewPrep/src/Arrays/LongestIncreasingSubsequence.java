package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestIncreasingSubsequence {

	int longestincreasing(int[] arr) {
		int T[] = new int[arr.length];
		int len=0;
		
		for(int i=0;i<arr.length;i++) {
			T[i] = 1;
		}
		
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i]) {
					T[i] = Math.max(T[i], T[j]+1);
				}
			}
		}
		return len;
	}
	
	
	
	//https://www.geeksforgeeks.org/longest-consecutive-subsequence/
	int longestConsecutiveSubsequence(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		int max = 0;
		
		for(int n : arr)
			set.add(n);
		
		for(int i=0;i<arr.length;i++) {
			//check for previous element, if not present then this is the strting point
			if(!set.contains(arr[i] - 1)) {
				int j = arr[i];
				
				while(set.contains(j))
					j++;
				
				max = Math.max(max, j-arr[i]);
			}
		}		
		return max;
	}	
}
