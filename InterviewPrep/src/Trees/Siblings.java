package Trees;

public class Siblings {
	
	// print nodes that doesnt have a sibling
	// sibling is a node that has same parent
	// print nodes that has only one child
	public void nosiblings(Tree root) {
		
		if(root == null)
			return;
			
		if(root.left != null && root.right != null) {
			nosiblings(root.left);
			nosiblings(root.right);
		}
		else if(root.right != null) {
			System.out.println(root.right.data);
			nosiblings(root.right);
		}
		else if(root.left != null) {
			System.out.println(root.left.data);
			nosiblings(root.left);
		}
	}
	
	
	
	// https://www.geeksforgeeks.org/find-right-sibling-binary-tree-parent-pointers/
	public Tree findRightSibling(Tree root, int level) {
		if(root == null)
			return null;
		
		// if its a right child OR if its a left child and does not have a right sibling (i.e right child is null for its parent)
		while( root.parent.right == root || (root.parent.left == root && root.parent.right == null)) {
			if(root.parent == null)
				return null;
			
			level--;
			root = root.parent; // keep going upwards until you find a right child for the parent
		}
		
		root = root.parent.right;
		
		// find right sibling in the given subtree(from current 
        // node), until level will be 0 
		while(level < 0) {
			if(root.left != null) {
				root = root.left;
			}
			else if(root.right != null) {
				root=root.right;
			}
			else
				break;
			
			level++;
		}
		
		if (level == 0)  
            return root;
		
		return findRightSibling(root, level);
	}
}
