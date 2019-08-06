package DynamicProgramming;

public class ClimbingStairs {
	
	public int climbing(int n) {
		int[] dp = new int[n+1];
		
		if (n == 1) {
            return 1;
        }
		
        if (n == 2) {
            return 2;
        }
        
		dp[0] = 0; // when there are 0 steps, there are 0 ways to reach dest
		dp[1] = 1; // when there are 1 step, there is 1 way to reach dest
		dp[2] = 2; // when there are 2 step, there are 2 way to reach dest
		// so for every step dp[i] there are dp[i-1] + dp[i-2] ways
		for(int i=3;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
}
