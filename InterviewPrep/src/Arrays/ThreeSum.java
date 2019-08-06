package Arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] num, int target) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    
	    for (int i = 0; i < num.length-2; i++) {
	    		// duplicates for i
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1;
	            while (lo < hi) {
	                if (num[lo] + num[hi] + num[i] == target) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    // duplicates for j
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    // duplicates for k
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < target) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
}
