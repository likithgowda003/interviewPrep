package String;

public class PalindromicPermutation {
	
	// check if a string can be made palindromic by permutation
	public class Solution {
	    public boolean canPermutePalindrome(String s) {
	        int[] arr = new int[128];
	        
	        for (int i = 0; i < s.length(); i++) {
	            arr[s.charAt(i)]++;
	        }
	        
	        // find the number of odd characters (should be max 1)
	        int count = 0;
	        for (int i = 0; i < arr.length && count <= 1; i++) {
	        		if( arr[i] % 2 != 0) {
	        			count ++;
	        		}
	        }
	        
	        if(count <= 1)
	        		return true;
	        
	        return false;
	    }
	}
}	
