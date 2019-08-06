package Medium;

public class LongestSubstringWithoutRepeatingCharacter {

	int longestsubstring(String str){
		int[] visited = new int[256];
		int cur_len = 1;
		int max_len = 1;
		int pre_index = 0;
		
		for(int i=0;i<visited.length;i++) {
			visited[i] = -1;
		}
		
		// store recent index of a character in the visited array
		visited[str.charAt(0)] = 0;
		
		for(int i=1;i<str.length();i++) {
			pre_index = visited[str.charAt(i)];
			
			// if its a new character which is not visited OR its not in the current NRCS process
			if(pre_index == -1 || i - cur_len > pre_index) {
				cur_len++;
			}
			else
			{
				if(cur_len > max_len)
					max_len = cur_len;
				
				// update cur length = cur position(i) - prev index 
				cur_len = i - pre_index;
			}
			visited[str.charAt(i)] = i;
		}
		
		// check for max length for the last NRCS
		if(cur_len >  max_len)
			max_len = cur_len;
		
		return max_len;
	}
}
