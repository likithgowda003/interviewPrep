package DynamicProgramming;

public class Fibobacci {
	
	
	public int recursive(int n) 
    { 
		if (n <= 1) 
			return n; 
		return recursive(n-1) + recursive(n-2); 
    } 
	
	
	
	
	
	public int dp(int n) {
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
}
