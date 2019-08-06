package DynamicProgramming;

public class HouseRobber {
	
	public int robber(int[] arr) {		
		if(arr.length == 0 || arr == null)
			return 0;
		
		int[] dp = new int[arr.length];
		
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);// max of first and second house
		
		for(int i=2;i<arr.length;i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]); // max of (i-1)th house and (i-2) + arr[i] house
		}
		return dp[arr.length-1];
	}
	
	
	
	// houses are in circular fashion
	public int robberII(int arr[]) {
		if(arr.length == 0 || arr == null)
			return 0;
		
		int max1 = helper(arr, 0, arr.length-2); // include first house and exclude last house
		int max2 = helper(arr, 1, arr.length-1); // exclude first house and include last house
		
		return Math.max(max1, max2);
		
	}

	private int helper(int[] arr, int i, int j) {
		int[] dp = new int[arr.length];
		
		dp[i] = arr[i];
		dp[i+1] = Math.max(dp[i], arr[i+1]);
		
		for(int k=i+2;k<=j;k++) {
			dp[k] = Math.max(dp[k-1], dp[k-2]+arr[k]);
		}
		return dp[arr.length-1];
	}
}
