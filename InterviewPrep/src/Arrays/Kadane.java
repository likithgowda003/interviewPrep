package Arrays;

public class Kadane {
	
	static void maxSubArraySum(int a[], int size) 
    { 
        int max_so_far = Integer.MIN_VALUE, 
        max_ending_here = 0,start = 0, 
        end = 0, s = 0; 
  
        for (int i = 0; i < size; i++)  
        { 
            max_ending_here += a[i]; 
  
            if (max_so_far < max_ending_here)  
            { 
                max_so_far = max_ending_here; 
                start = s; 
                end = i; 
            } 
  
            if (max_ending_here < 0)  
            { 
                max_ending_here = 0; 
                s = i + 1; 
            } 
        } 
        System.out.println("Maximum contiguous sum is " 
                           + max_so_far); 
        System.out.println("Starting index " + start); 
        System.out.println("Ending index " + end); 
    } 
	
	
	
	static void kadane(int a[]) {
		int max_ending_here = 0;
		int max_so_far = Integer.MIN_VALUE;
		
		for(int i=0;i<a.length;i++) {
			max_ending_here = max_ending_here + a[i];
			
			if(max_ending_here < 0)
				max_ending_here = 0;
			
			if(max_ending_here > max_so_far)
				max_so_far = max_ending_here;
		}
	}
	
	
	
	//https://www.geeksforgeeks.org/maximum-product-subarray/
	int maxProductSubarray(int[] a) {
		int max_ending_here = 1;
		int min_ending_here = 1;
		int max_so_far = 1;
		
		for(int i=0;i<a.length;i++) {
			
			if(a[i] > 0) {
				max_ending_here = max_ending_here * a[i];
				min_ending_here = Math.min(min_ending_here * a[i], 1);
			}
			else if(a[i] == 0) {
				max_ending_here = 1;
				min_ending_here = 1;
			}
			else
			{
				int temp = max_ending_here;
				max_ending_here = Math.max(min_ending_here * a[i], 1);
				min_ending_here = temp * a[i];
			}
			 max_so_far = Math.max(max_so_far, max_ending_here);
		}
		return max_so_far;
	}
}
