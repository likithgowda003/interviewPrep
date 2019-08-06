package DynamicProgramming;

public class CoinChange {
	public int coinchange(int[] coins, int total) {
		 
		int[][] T = new int[total+1][coins.length];
		for(int i=0;i<=coins.length;i++) {
			for(int j=0;j<=total;j++) {
				// first col 0
				if(j==0) {
					T[i][j] = 0;
				}
				// if cur coin value is greater than j, then get top element
				else if(coins[i] > j) {
					T[i][j] = T[i-1][j];
				}
				// get min of top element and 1+(go back coin value to left)
				else {
					T[i][j] = Math.min(T[i-1][j], 1+T[i][j-coins[i]]);
				}
			}
		}
		return T[total][coins.length];
	}
}
