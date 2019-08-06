package Trees;

// find inorder successor of node p
// if it has right child, successor of p is the min node(leftmost) on its right subtree
public class InorderSuccessor {
	
	public Tree InorderSuccessor1(Tree root, Tree node) {
		// if right child of node is not null. get leftmost node in the right subtree 
		if(node.right != null) {
			return minValue(node.right);
		}
		
		Tree parent = node.parent;
		// for pred, traverse until node is not the left child of parent
		// for succ, traverse until node is not the right child of parent
		while(parent != null && node == parent.right) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	private Tree minValue(Tree right) {
		Tree suc = right;
		while(suc.left !=null) {
			suc = suc.left;
		}
		return suc;
	}


	
	// method 2 : traversing downwards
	public Tree inordersuccessor(Tree root, Tree node) {
		
		// find minvalue in the right subtree
		if(node.right != null) {
			return minValue(node.right);
		}
		
		// track root as successor and go deep until u find the node
		Tree succ = null;
		while(root != null) {
			if(node.data < root.data) {
				// keepinf track of root as succ and going inside
				succ = root;
				root = root.left;
			}
			else if (node.data > root.data)
				root = root .right;
			else
				break;
		}
		return succ;
	}
}
