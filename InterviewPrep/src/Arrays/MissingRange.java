package Arrays;

import java.util.ArrayList;
import java.util.List;

// https://www.programcreek.com/2013/03/leetcode-missing-ranges-java/
// Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
// Output: ["2", "4->49", "51->74", "76->99"]
public class MissingRange {
	
	public List<String> findMissingRanges(int[] arr, int lower, int upper) {
		
		List<String> res = new ArrayList<String>();
		int start = lower;
		
		if(lower == Integer.MAX_VALUE)
			return res;
		
		for(int i=0;i<arr.length;i++) {
			
			// handle duplicates
			if(i<arr.length && arr[i] == arr[i+1])
				continue;
			
			if(arr[i] == start) {
				start++;
			}
			else {
				res.add(getRange(start, arr[i]-1));
				if(arr[i] == Integer.MAX_VALUE)
					return res;
				start = arr[i]+1;
			}
		}
		
		if(start <= upper)
			res.add(getRange(start, upper));
			
		return res;
	}

	private String getRange(int a, int b) {
		// TODO Auto-generated method stub
		return a == b ? String.valueOf(b) : String.format("%d -> %d", a, b);
	}
	
	
	//=================================================================================================
			
	
	// https://www.programcreek.com/2014/07/leetcode-summary-ranges-java/
	// For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
	
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		 
	    if(nums == null || nums.length==0)
	        return res;
	 
	    if(nums.length==1){
	        res.add(nums[0]+"");
	    }
	 
	    int pre = nums[0]; // previous element   
	    int first = pre; // first element of each range
	    
	    for(int i=1;i<nums.length;i++) {
	    	
	    		if(nums[i] == pre+1) {
	    			if(i == nums.length-1)
	    				res.add(first + "->" + nums[i]);
	    		}
	    		else
	    		{
	    			if(first == pre) {
	    				res.add(first+"");
	    			}
	    			else 
	    			{
	    				res.add(first+"->"+pre);
	    			}
	    			
	    			if(i == nums.length-1) {
	    				res.add(nums[i]+"");
	    			}
	    			first = nums[i];
	    		}
	    		
	    		pre = nums[i];
	    }
	}
}
