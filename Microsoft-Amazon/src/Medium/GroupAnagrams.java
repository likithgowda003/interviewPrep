package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		List<List<String>> res = new ArrayList<List<String>>();
		char[] arr = new char[26];
		
		for(String str: strs) {
			for(int i=0;i<str.length();i++) {
				arr[str.charAt(i)-'a']++;
			}
			String ns = new String(arr);
			
			if(map.containsKey(ns)) {
				map.get(ns).add(str);
			}
			else
			{
				ArrayList<String> list = new ArrayList<String>();
				list.add(str);
				map.put(ns, list);
			}
		}
		res.addAll(map.values());
		return res;
	}

}
