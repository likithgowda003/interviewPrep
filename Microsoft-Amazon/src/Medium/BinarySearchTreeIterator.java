package Medium;

import java.util.Stack;

import Hard.Tree;

public class BinarySearchTreeIterator {
	Stack<Tree> stack = new Stack<Tree>();
	
	public BinarySearchTreeIterator(Tree root) {
		push(root);
		
	}
	
	private void push(Tree root) {
		while(root != null) {
			stack.push(root);
			root = root.left;
		}		
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		Tree node = stack.pop();
		int res = node.getData();
		
		if(node.right!=null) {
			node = node.right;
			while(node!=null) {
				push(node);
				node = node.left;
			}
		}
		return res;
	}
}
