package Medium;

import java.util.Stack;

import Hard.Tree;

public class FlattenBTtoLinkedList {
	
	public void binaryTreetoLL(Tree root) {
		Stack<Tree> stack = new Stack<Tree>();
		Tree cur = root;
		
		while(cur != null || !stack.isEmpty()) {
			
			if(cur.right != null) {
				stack.push(cur.right);
			}
			
			if(cur.left != null) {
				cur.right = cur.left;
				cur.left = null;
			}
			else if(!stack.isEmpty()) {
				Tree temp = stack.pop();
				cur.right = temp;
			}
			
			cur = cur.right;
		}
	}
}
