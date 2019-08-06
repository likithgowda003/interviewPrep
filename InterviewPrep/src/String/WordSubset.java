package String;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Example 1:
	Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
	Output: ["facebook","google","leetcode"]
	
	Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
	Output: ["facebook","google"]
 */

public class WordSubset {
	
	public static void main(String[] args) {
		String[]  A = {"amazon","apple","facebook","google","leetcode"};
		String[] B = {"oo","e"};
		List<String> res = wordSubsets(A,B);
		for(String s : res) {
			System.out.println(s);
		}
	}
	
	public static List<String> wordSubsets(String[] A, String[] B) {
		ArrayList<String> result = new ArrayList<String>();
		
		// for each pattern
		for(String s : B) {
			
			// check all strings
			for(String str : A) {
				result.add(str);
				
				// create map with character and count
				Map<Character, Integer> map = new HashMap<Character, Integer>();
				for(int i=0;i<str.length();i++) {
					if(map.containsKey(str.charAt(i))) {
						map.put(str.charAt(i), map.get(str.charAt(i))+1);
					}
					else
					{
						map.put(str.charAt(i), 1);
					}
				}
				
				characterCheck(map, s, str, result);
				
			}
		}
		return result;
	}

	
	private static ArrayList<String> characterCheck(Map<Character, Integer> map, String B, String A, ArrayList<String> result) {
		
		for(int i=0;i<B.length();i++) {
			char ch = B.charAt(i);
			if(map.containsKey(ch) && map.get(ch) >= 1) {
				map.put(ch, map.get(ch)-1);
			}
			else if((map.containsKey(ch) && map.get(ch) == 0) || !map.containsKey(ch)) {
				result.remove(A);
			}
		}
		return result;
	}
}
