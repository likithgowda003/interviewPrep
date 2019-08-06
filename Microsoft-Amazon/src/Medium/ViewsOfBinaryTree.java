package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Easy.Node;

public class ViewsOfBinaryTree {
	static int max_level = 0;
	
	void rightview(Node root, int level) {
		if(root == null)
			return;
		
		if(max_level < level) {
			System.out.println(root.getData());
			max_level = level;
		}
		// Recur for right subtree first, then left subtree
		rightview(root.getNext(), level+1);
		rightview(root.getNext(), level+1);
	}
	
	
	// for top view, get the first elements of the arraylist
	// for bottom view, overide the value of the hashmap for every key
	void topview(Node root, int level, HashMap<Integer, List<Integer>> map) {
		if(root == null)
			return;
		
		if(map.get(level) == null) {
			map.put(level, new ArrayList(root.getData()));
		}
		else
		{
			//map.put(level, map.get(level).add(root.getData()));
		}
		
		topview(root.getNext(), level-1, map);
		topview(root.getNext(), level+1, map);		
	}
}
