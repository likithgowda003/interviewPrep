package DynamicProgramming;

//https://www.geeksforgeeks.org/number-of-ways-to-calculate-a-target-number-using-only-array-elements/

// Given an integer array, find number of ways to calculate a target number using only array elements and addition or subtraction operator.

// we either include the current digit or ignore it. If we include the current digit, we subtract or add it from remaining 
// target and recurse for remaining digits with new target. If target reaches 0, we increment the count
public class FindTotalWays {
	
	public int countways(int[] arr, int i, int target) {
		
		// If all elements are processed and  
        // target is not reached, return 0  
		if(i>=arr.length && target != 0)
			return 0;
		
		if( target == 0)
			return 1;
		
		return countways(arr, i+1, target) // ignore the cur element
				+ countways(arr, i+1, target - arr[i]) // subtract curr element
				+ countways(arr, i+1, target + arr[i]); // add curr element
	}
}
