package String;

public class CountAndSay {
	//The count-and-say sequence is the sequence of integers beginning as follows:
	//1, 11, 21, 1211, 111221, ...
	
	//1 is read off as "one 1" or 11.
	//11 is read off as "two 1s" or 21.
	//21 is read off as "one 2, then one 1" or 1211
	public String countandsay(String n) {
		
		StringBuilder sb  = new StringBuilder();
		
		for(int i=0;i<n.length();i++) {
			int j=i+1;
			int count=1;
			
			// increment count until a[i] != a[j]
			while(n.charAt(i) == n.charAt(j) && j<=n.length()) {
				count++;
				j++;
			}
			
			sb.append(count);
			sb.append(n.charAt(i));
			i=j;
		}
		return sb.toString();	
	}
}
