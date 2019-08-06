package Trees;

import LinkedList.Node;

public class BTtoDLL {
	static Tree head;
	static Tree root;
	static Tree prev = null;
	
	public void BTtoDLL(Tree root) {
		if(root == null)
			return;
		
		BTtoDLL(root.left);
		
		if(prev == null) {
			head = root;
		}
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		
		BTtoDLL(root.right);
	}
}
