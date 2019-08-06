package Trees;

import java.util.LinkedList;

public class InvertBinaryTree {
	
	Tree invert(Tree root) {
		if(root == null)
			return null;
		
		invert(root.left);
		invert(root.right);
		
		Tree t = root.left;
		root.left = root.right;
		root.right = t;
		
		return root;
	}
	
	
	
	Tree InvertIterative(Tree root) {
		LinkedList<Tree> queue = new LinkedList<Tree>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			Tree top = queue.poll();
			
			if(top.left != null)
				queue.add(top.left);
			
			if(top.right != null)
				queue.add(top.right);
			
			Tree temp = top.left;
			top.left = top.right;
			top.right = temp;
		}
		return root;
	}
}
