package DynamicProgramming;

public class Knapsack {
	
	public int kanpsack(int W, int wt[], int val[], int n) {
		int[][] k = new int[n+1][W+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=W;j++) {
				// first col is 0
				if(i==0 || j==0) {
					k[i][j] = 0;
				}
				// if wt is greater than j, then get the top element in the matrix
				else if(wt[i-1] > j) {
					k[i][j] = k[i-1][j];
				}
				// if wt is less than j, then get max of top value and cur value + (top row - wt)
				else
					k[i][j] = Math.max(k[i-1][j], val[i-1] + k[i-1][j-wt[i-1]]);
			}
		}
		return k[n][W];
	}
}
