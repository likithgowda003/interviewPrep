package String;

// compare 2 strings character by character
// if same, proceed to next
// else increment count and check count > 1 (if >1 return false)

public class OneEditDistance {
	
	public boolean compare(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		// if diffrenece in length > 1 return false
		if(Math.abs(m-n) > 1)
			return false;
		
		int i=0,j=0,count=0;
		
		while(i<m && j<n) {
			// if same characters, increment i and j
			if(s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			}
			else
			{	
				count++;
				if(count > 1) {
					return false;
				}
				else 
				{	
					// if s1 length is greater move i forward  
					if(m > n) 
					{
						i++;
					}
					// if s2 length is greater move j forward
					else if(m < n) 
					{
						j++;
					}
					else
					{
						i++;
						j++;
					}
				}
							
			}
		}
		
		if(i<m || j<n)
			count++;
		
		if(count == 1)
			return true;
		
		return false;
	}
}
