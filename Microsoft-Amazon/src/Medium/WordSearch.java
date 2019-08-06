package Medium;import java.util.Dictionary;

// word search 2 using Trie: https://www.programcreek.com/2014/06/leetcode-word-search-ii-java/


public class WordSearch {
	
	public static String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
	
	public static void main(String args[]) {
		char[][] boggle = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};
		findword(boggle);
	}

	private static void findword(char[][] boggle) {
		boolean visited[][] = new boolean[3][3];
		String str = "";
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				helper(boggle,visited,i,j, str);
			}
		}
	}

	private static void helper(char[][] boggle, boolean[][] visited, int i, int j, String str) {
		visited[i][j] = true;
		str = str + boggle[i][j];
		
		if(isWord(str)) {
			System.out.println(str);;
		}
		
		for(int row=i-1;row<=i+1 && row<3;row++) {
			for(int col=j-1;col<=j+1 && col<3;col++) {
				if(row >= 0 && col >= 0 &&!visited[row][col]) {
					helper(boggle, visited, row, col, str);
				}
			}
		}
		
		str = str.substring(0, str.length()-1);
		visited[i][j] = false;
	}

	private static boolean isWord(String str) {
		for(int i=0;i<dictionary.length;i++) {
			if(str.compareTo(dictionary[i]) == 0) 
				return true;
		}
		return false;
	}
}
