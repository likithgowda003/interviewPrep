package Medium;

public class DecodeWays {
	
	// recursive
	// O(2^n)
	public int decode(char[] arr, int n) {
		if(n == '0' || n == '1')
			return 1;
		
		int count = 0;
		
		if(arr[n-1] > '0')
			count = decode(arr, n-1);
		
		if(arr[n-2] == '1' || arr[n-2] == '2' && arr[n-1] < '7')
			count += decode(arr, n-2);
		
			return count;
	}
	
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
