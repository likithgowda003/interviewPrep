package DynamicProgramming;

public class NumberOfUniqueBST {
	// https://leetcode.com/problems/unique-binary-search-trees/discuss/31707/Fantastic-Clean-Java-DP-Solution-with-Detail-Explaination
	public int numTrees(int n) {
	    int [] dp = new int[n+1];
	    dp[0]= 1;
	    dp[1] = 1;
	    for(int level = 2; level <=n; level++)
	        for(int root = 1; root<=level; root++)
	            dp[level] += dp[level-root]*dp[root-1];
	    return dp[n];
	}
}
