package Trees;

// if it has left child, predecessor is the max node(right most) on its left subtree
// if it does not have child node, traverse upwards until it is not the left child of its parent.
public class InorderPredecessor {
	public Tree predecessor(Tree root, Tree node) {	
		Tree predecessor = null;
		if(node.left != null){
			predecessor = maxValue(node.left);
		}
		else {
			Tree parent = node.parent;
			// traverse upwards until the node is not the left child of its parent
			while(parent != null && node == parent.left) {
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
		return predecessor;
	}

	private Tree maxValue(Tree node) {
		Tree pre = node;
		while(pre.right != null) {
			pre = pre.right;
		}
		return pre;
	}
	
	
	
	// method 2
	// if it has left child, predecessor is the max node on its right subtree
	// while moving downwards, keep track of the parent as predecessor and change it as and wen u go downwards
	public Tree predecessor1(Tree root, Tree node) {	
		
		if(node.left != null){
			return maxValue1(node.left);
		}
		
		Tree pre = null;
		while(root  != null) {
			if(node.data > root.data) {
				pre = root;
				root = root.right;
			}
			else if(node.data < root.data) {
				root = root.left;
			}
			else
				 break;
		}
		return pre;
	}
	
	private Tree maxValue1(Tree node) {
		Tree pre = node;
		while(pre.right != null) {
			pre = pre.right;
		}
		return pre;
	}
}
