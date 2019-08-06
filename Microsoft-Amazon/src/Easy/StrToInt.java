package Easy;

public class StrToInt {
		
	int atoi(String str) {
		if(str == null)
			return 0;
		
		int res = 0;
		int sign = 1;
		
		if(str.charAt(0) == '-') {
			sign = -1;
		}
		
		for(int i=0;i<str.length();i++) {
			if(isNumeric(str.charAt(i)))
				res = res * 10 + str.charAt(i) - '0';
			else
				return 0;
		}
		
		return res*sign;
		
	}

	private boolean isNumeric(char c) {
		return (c >= '0' && c <= '9');
	}
	

}
