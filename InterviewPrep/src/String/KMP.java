package String;

public class KMP {
	
	int[] temparray(String pat) {
		int[] lps = new int[pat.length()];
		int j=0,i=1;
		
		while(i<pat.length()) {
			if(pat.charAt(i) == pat.charAt(j)) {
				lps[i] = j+1;
				i++;
				j++;
			}
			else
			{
				if(j!=0) {
					j = lps[j-1];
				}
				else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
	
	boolean kmp(String str, String pat) {
		int lps[] = temparray(pat);
        int i=0;
        int j=0;
        while(i<str.length() && j<pat.length()) {
	        	if(pat.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			else
			{
				if(j!=0) {
					j = lps[j-1];
				}
				else {
					lps[i] = 0;
					i++;
				}
			}
        }
        if(j == pat.length()){
            return true;
        }
        return false;
	}
}
