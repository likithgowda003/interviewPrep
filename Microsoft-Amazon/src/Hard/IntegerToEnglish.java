package Hard;

import java.util.HashMap;

public class IntegerToEnglish {
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	
	public String intToEng(int n) {	
		StringBuilder sb = new StringBuilder();
		
		fillMap();
		
		if(n >= 0 && n<=20)
			return map.get(n);
		
		if(n >= 1000000000) {
			int value = n/1000000000;
			sb.append(convert(value) + "Billion");
			n = n % 1000000000;
		}
		
		if(n >= 1000000) {
			int value = n/1000000;
			sb.append(convert(value) + "Million");
			n = n % 1000000;
		}
		
		if(n >= 1000) {
			int value = n/1000;
			sb.append(convert(value) + "Thousand");
			n = n % 1000;
		}
		return sb.toString();
	}

	
	
	private String convert(int num) {
		StringBuilder sb = new StringBuilder();
		
		// 2 hundred billion
		if(num >= 100) {
			int numHundred = num/100;
			sb.append(map.get(numHundred) + "Hundred");
			num = num%100;			
		}
		
		if(num > 0) {
			// fifteen billion
			if(num > 0 && num <= 20) {
				sb.append(map.get(num));
			}
			else {
				// thirty five billion
				
				// get three here
				int numTen = num/10;
				sb.append(map.get(numTen * 10));
				
				// get five here
				int numOne = num % 10;
				if(numOne > 0)
					sb.append(map.get(numOne));
			}
		}
		return sb.toString();
	}

	
	
	private void fillMap() {
		map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
	}
	
}
