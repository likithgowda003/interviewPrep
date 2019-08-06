package Trees;

public class LCABinaryTree {
	
	Tree LCA(Tree root, Tree p, Tree q) {
		if(root == null)
			return null;
		
		if(root == p || root == q)
			return root;
		
		Tree left  = LCA(root.left, p, q);
		Tree right = LCA(root.right, p, q);
		
		if(left == null && right == null)
			return null;
		
		else if(left != null && right != null)
			return root;
		
		else
			return left == null ? right : left;
	}
}
