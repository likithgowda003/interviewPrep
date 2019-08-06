package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
// https://www.programcreek.com/2014/05/leetcode-group-shifted-strings-java/
	
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    
	    for(String str:strings) {
	    		char[] arr = str.toCharArray();
	    		if(str.length() > 0) {
	    			int diff = arr[0] - 'a';
	    			for(int i=0;i<arr.length;i++) {
	    				if(arr[i] - diff < 'a') {
	    					arr[i] = (char) (arr[i] - diff + 26);
	    				}else {
	    					arr[i] = (char) (arr[i] - diff);
	    				}
	    			}
	    		}
	    		
	    		String ns = new String(arr);
	    		if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
	    }
	    
	    for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
	        Collections.sort(entry.getValue());
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}	
}
