package Easy;

import javax.management.RuntimeErrorException;

public class ExcelSheet {

	public int TitleToNumber(String str) {
		if(str.length() == 0)
			return 0;
		
		int i=str.length();
		int res = 0;
		int p = 0;
		while(i>=0) {
			char ch = str.charAt(i);
			res = res + (ch-'A'+1) * (int)Math.pow(26, p);
			i--;
			p++;
		}
		return res;
	}
	
	
	
	
	public String NumberToTitle(int n) {
		if(n<=0) {
			throw new IllegalArgumentException("Input is not valid!");
		}
		
		StringBuilder sb = new StringBuilder();
		while(n>0) {
			char ch = (char) (n%26 + 'A');
			n= n/26;
			sb.append(ch);
		}
		sb.reverse();
		return sb.toString();
	}
}
