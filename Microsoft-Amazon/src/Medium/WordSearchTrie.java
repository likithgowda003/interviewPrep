package Medium;

import java.util.ArrayList;
import java.util.List;

public class WordSearchTrie {
	List<String> res = new ArrayList<String>();
	Trie trie =  new Trie();

	public List<String> search(char[][] board, String[] words){
		if(board == null)
			return null;
		
		for(String str : words)
			trie.insert(str);
		
		boolean visited[][] = new boolean[board.length][board[0].length];
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				dfs(board, visited, i, j, trie, "");
			}
		}
		return res;
	}
	
	public void dfs(char[][] board, boolean[][] visited, int i, int j, Trie trie, String str) {
		
		if(visited[i][j])
			return;
		
		if(i<0 || j<0 || i>board.length || j>board[0].length)
			return;
		
		str = str + board[i][j];
		
		if(!trie.startsWith(str))
			return;
		
		if(trie.search(str))
			res.add(str);
		
		visited[i][j] = true;
		
		dfs(board, visited, i+1, j, trie, str);
		dfs(board, visited, i-1, j, trie, str);
		dfs(board, visited, i, j+1, trie, str);
		dfs(board, visited, i, j-1, trie, str);
		
		visited[i][j] = false;
		
	}
}
