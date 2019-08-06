package Medium;

public class HouseRobber {

	public int robber(int arr[]) {
		int dp[] = new int[arr.length];
		
		if(arr.length == 0)
			return 0;
		
		if(arr.length == 1)
			return arr[0];
		
		if(arr.length == 2)
			return Math.max(arr[0],arr[1]);
		
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		
		for(int i=2;i<arr.length;i++) {
			dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
		}
		
		return dp[arr.length-1];
	}
	
	
	
	// circular houses, follow the above approach but with 2 cases
	// case 1: include first house and exclude last house
	// case 2: exclude first house and include last house
	public int robber2(int arr[]) {
		int n = arr.length;
		
		if(n == 1)
			return arr[0];
		
		int max1 = helper(arr, 0, n);
		int max2 = helper(arr, 1, n);
		
		return Math.max(max1, max2);
	}

	private int helper(int[] arr, int i, int n) {
		if(i == n)
			return arr[i];
		
		int[] dp = new int[n];
		dp[i] = arr[i];
		dp[i+1] = Math.max(arr[i+1], dp[i]);
		
		for(int k=i+2;k<n;k++) {
			dp[k] = Math.max(arr[k]+dp[k-2], dp[k-1]);
		}		
		return dp[n];
	}
}
