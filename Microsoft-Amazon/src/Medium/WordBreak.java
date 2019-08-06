package Medium;

// https://www.geeksforgeeks.org/word-break-problem-dp-32/
public class WordBreak {
	
	public static String dictionary[] = {"mobile","samsung","sam","sung", 
            "man","mango","icecream","and", 
             "go","i","like","ice","cream"}; 
	
	public boolean wordbreak(String str) {
		
		if(str.length() == 0)
			return true;
		
		// Try all prefixes of lengths from 1 to size 
		for(int i=1;i<str.length();i++) {
			if(dictionaryContains(str.substring(0, i)) && wordbreak(str.substring(i, str.length()-1))){
				return true;
			}
		}
		return false;
	}

	private boolean dictionaryContains(String substring) {
		for(int i=0;i<dictionary.length;i++) {
			if(substring.compareTo(dictionary[i]) == 0)
				return true;
		}
		return false;
	}
}
