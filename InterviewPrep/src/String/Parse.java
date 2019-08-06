package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// For exmple, string="abc(edf)hij{klmn}opq[rst]uvw"
// ["abc", "edf", "hij", "klmn", "opq", "rst", "uvw"]

public class Parse {
	public static List<String> parse(String str){
		if(str == null)
			return null;
		
		List<String> res = new ArrayList<String>();
		String sub = "";
		Map<Character,Character> map = new HashMap<Character, Character>();
		
		for(int i=0;i<str.length();i++) {
			if(map.keySet().contains(str.charAt(i))) {
				res.add(sub);
				sub = "";
				char ch = str.charAt(i);
				i++;
				while(i < str.length() && str.charAt(i) != map.get(ch)) {
					sub += str.charAt(i);
					i++;
				}
				res.add(sub);
				sub="";
				i++;
			}
			else {
				sub += str.charAt(i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String str = "abc(edf)hij{klmn}opq[rst]uvw";
		List<String> res = parse(str);
		
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
		
	}
}
