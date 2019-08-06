package DynamicProgramming;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int m = S.length()+1;
		int n = T.length()+1;
		int[][] dp  = new int[m][n];
		
		for(int i=0;i<=m;i++) {
			dp[i][0] = 1;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(S.charAt(i-1) == T.charAt(j-1)) {
					dp[i][j] += dp[i-1][j] + dp[i-1][j-1];
				}
				else
					dp[i][j] += dp[i-1][j];
			}
		}
		return dp[m][n];
	}
}
