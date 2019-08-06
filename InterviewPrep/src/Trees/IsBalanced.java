package Trees;

public class IsBalanced {
	
	public boolean Isbalanced(Tree root) {
		if(root == null)
			return true;
		
		int l = height(root.left);
		int r = height(root.right);
		
		if(Math.abs(l-r) >=1 && Isbalanced(root.left) && 	Isbalanced(root.right))
			return true;
		
		return false;
	}

	private int height(Tree root) {
		if(root == null)
			return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
