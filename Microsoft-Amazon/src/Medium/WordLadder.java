
package Medium;

import java.util.LinkedList;
import java.util.Set;

/*
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, 
 * such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. 
 * For example, given:
  	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	
	One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 */
public class WordLadder {

	public class WordNode{
		String word;
		int numSteps;
		
		public WordNode(String word, int numSteps) {
			this.word = word;
			this.numSteps = numSteps;
		}
	}
	
	
	public int ladderlength(String begin, String end, Set<String> dictionary) {
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		
		queue.add(new WordNode(begin, 1));
		dictionary.add(end);
		
		while(!queue.isEmpty()) {
			WordNode wordnode = queue.poll();
			String word = wordnode.word;
			
			// break condition
			// check if the end word is in the dictionary
			if(dictionary.contains(word))
				return wordnode.numSteps;
			
			// replace each and every character in the string within a-z and check if its in the dictionary to increment the count
			char[] arr = word.toCharArray();
			for(int i=0;i<arr.length;i++) {
				for(char c='a';c<='z';c++) {
					char temp = arr[i];
					// replacing character of the string
					if(arr[i] != c) {
						arr[i] = c;
					}
					
					String newWord = new String(arr);
					if(dictionary.contains(newWord)) {
						queue.add(new WordNode(newWord, wordnode.numSteps+1));
						dictionary.remove(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return 0;
	}
}
