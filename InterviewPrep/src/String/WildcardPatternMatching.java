package String;

import java.util.Arrays;

public class WildcardPatternMatching {
	boolean patternmatching(String str, String pat, int n, int m) {
		boolean[][] lookup = new boolean[n+1][m+1];
		
		if(m==0) {
			return n==0;
		}
		
		for(int i=0;i<n+1;i++) {
			Arrays.fill(lookup[i], false);
		}
		
		lookup[0][0] = true;
		for(int j=1;j<m+1;j++) {
			if(pat.charAt(j-1)=='*') {
				lookup[0][j] = lookup[0][j-1];
			}
		}
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				if(pat.charAt(j-1) == '*') {
					lookup[i][j] = lookup[i][j-1] || lookup[i-1][j]; 
				}
				else if(pat.charAt(j-1) == '?' || str.charAt(i-1) == pat.charAt(j-1)) {
					lookup[i][j] = lookup[i-1][j-1];
				}
				else
					lookup[i][j] = false;
			}
		}
		return lookup[m][n];
	}
}
