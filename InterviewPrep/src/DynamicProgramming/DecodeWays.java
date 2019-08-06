package DynamicProgramming;

public class DecodeWays {

	// dynamic
		// O(n)
		
		public int decodeIterative(char[] digits, int n) {
			int[] dp = new int[n+1];
			
			// empty string
			dp[0] = 0; 
			dp[1] = 1;
			
			for(int i=2;i<n;i++) {
				
				// A starts from 1
				if(digits[i-1] > '0')
					dp[i] = dp[i-1];
				
				// if first digit is 1 OR if first digit is 2, then second digit has to be less than 7 (within range 26) 
				if(digits[i-2] == '1' || digits[i-2]=='2' && digits[i-1]<'7')
					dp[i] += dp[i-2];
			}
			
			return dp[n];
		}
}
