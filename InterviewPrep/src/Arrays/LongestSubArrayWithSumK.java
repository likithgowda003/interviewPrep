package Arrays;

import java.util.HashMap;

// https://www.geeksforgeeks.org/longest-sub-array-sum-k/
// https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
public class LongestSubArrayWithSumK {
	
	public int longestsubarray(int[] arr, int target) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int max_len = 0;
		
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
			
			// sub array starts from index 0
			if(sum == target) {
				max_len = i+1; // 0 to i
			}
			
			// if sum not in map put it in map with index as value
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
			
			// when sum exceeds target and (sum-target) is in map
			if(map.containsKey(sum-target)) {
				max_len = Math.max(max_len, i - map.get(sum-target));
			}
		}
		return max_len;
	}
	
	
	
	// subarray with given sum k, need not be the longest like above
	public int subarraysum(int[] arr, int target) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int max_len = 0;
		int start = 0;
		int end = 0;
		
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
			
			// sub array starts from index 0
			if(sum == target) {
				start = 0;
				end  = i;
				break;
			}
			
			// if sum not in map put it in map with index as value
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
			
			// when sum exceeds target and (sum-target) is in map
			if(map.containsKey(sum-target)) {
				start =  map.get(sum-target);
				end = i;
				break;
			}
		}
		return max_len;
	}
	
	
	// another approach is to have add numbers and check for target, when sum exceeds target, remove the first element(like a window)
	int subArraySum(int arr[], int n, int sum)  
    { 
        int curr_sum = arr[0], start = 0; 
  
        // Pick a starting point 
        for (int i = 1; i <= n; i++)  
        { 
            // If curr_sum exceeds the sum, then remove the starting elements 
            while (curr_sum > sum && start < i-1) 
            { 
                curr_sum = curr_sum - arr[start]; 
                start++; 
            } 
              
            // If curr_sum becomes equal to sum, then return true 
            if (curr_sum == sum)  
            { 
                int p = i-1; 
                System.out.println("Sum found between indexes " + start 
                        + " and " + p); 
                return 1; 
            } 
              
            // Add this element to curr_sum 
            curr_sum = curr_sum + arr[i]; 
              
        } 
  
        System.out.println("No subarray found"); 
        return 0; 
    } 
	
}
