package Design;

public class TrieNode {
	TrieNode[] children = new TrieNode[26];
	String item = "";
}

public class Trie{
	TrieNode root = new TrieNode();
	
	public void insert(String word) {
		TrieNode node = root;
		
		for(char c : word.toCharArray()) {
			if(node.children[c-'a'] == null) {
				node.children[c-'a'] = new TrieNode();
			}
			node = node.children[c-'a'];
		}
		node.item = word;
	}
	
	public boolean search(String word) {
		TrieNode node = root;
		
		for(char c: word.toCharArray()) {
			if(node.children[c-'a'] == null) {
				return false;
			}
			node = node.children[c-'a'];
		}
		if(node.item == word)
			return true;
		return false;
	}
	
	public boolean startswith(String word) {
		TrieNode node = root;
		
		for(char c : word.toCharArray()) {
			if(node.children[c-'a'] == null) {
				return false;
			}
			node = node.children[c-'a'];
		}
		return true;
	}
}
