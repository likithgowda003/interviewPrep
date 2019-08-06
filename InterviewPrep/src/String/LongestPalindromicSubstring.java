package String;

// https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
public class LongestPalindromicSubstring {
	
	int longestpalindrome(String str){
		int n = str.length();
		int maxLength = 0;
		boolean[][] table = new boolean[n][n];
		
		for (int i = 0; i < n; ++i)
            table[i][i] = true;
		
		// check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
     // Check for lengths greater than 2. k is length
        // of substring
        for(int k=3;k<n;k++) {
        		for(int i=0;i<n-k+1;i++) {
        			int j = i+k-1;
        			if(table[i+1][j-1] && str.charAt(i)==str.charAt(j)) {
        				table[i][j] = true;
        			
        				if (k > maxLength) {
                        start = i;
                        maxLength = k;
        				}
        			}
        		}
        }
        return maxLength;
	}
}
