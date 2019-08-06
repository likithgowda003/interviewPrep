package DynamicProgramming;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9; 
        int n = set.length; 
        if (isSubsetSum(set, n, sum) == true) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 
    }

	private static boolean isSubsetSum(int[] arr, int n, int sum) {
		if(sum == 0)	
			return true;
		
		if(n==0 && sum!=0)
			return false;
		
		// If last element is greater than  
        // sum, then ignore it 
		if(arr[n-1] > sum)
			return isSubsetSum(arr, n-1, sum);
		
		/* else, check if sum can be obtained  
        by any of the following 
            (a) including the last element 
            (b) excluding the last element */
		return isSubsetSum(arr, n-1, sum) || isSubsetSum(arr, n-1, sum-arr[n-1]);
	} 
	

}
