package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {
	
	public static void main(String[] args) {
		List<String> ans = lettercombination("23");
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
	
	static List<String> lettercombination(String digits) {
		HashMap<Character, char[]> map = new HashMap<Character, char[]>();
	    map.put('2', new char[]{'a','b','c'});
	    map.put('3', new char[]{'d','e','f'});
	    map.put('4', new char[]{'g','h','i'});
	    map.put('5', new char[]{'j','k','l'});
	    map.put('6', new char[]{'m','n','o'});
	    map.put('7', new char[]{'p','q','r','s'});
	    map.put('8', new char[]{'t','u','v'});
	    map.put('9', new char[]{'w','x','y','z'});
	    
	    ArrayList<String> res = new ArrayList<String>();
	    if(digits.equals(""))
	        return res;
	    
	    helper(digits, map, res, 0, new StringBuilder());
	    
	    return res;
	}

	private static void helper(String digits, HashMap<Character, char[]> map, ArrayList<String> res, int index,
			StringBuilder sb) {
		
		if(index >= digits.length()) {
			res.add(sb.toString());
			return;
		}
		
		char ch = digits.charAt(index);
		char[] arr = map.get(ch);
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]);
			helper(digits, map, res, index+1, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}