package Trees;

public class IsSubtree {
	
	public boolean IsSubtree(Tree root1, Tree root2) {
		if(root1 == null)
			return true;
		
		if(root2 == null)
			return false;
		
		if(IsIdentical(root1,root2))
			return true;
		
		return IsSubtree(root1.left, root2) || IsSubtree(root1.right, root2);
	}

	private boolean IsIdentical(Tree root1, Tree root2) {
		
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		return (root1.data == root2.data && IsIdentical(root1.left, root2.left) && IsIdentical(root1.right, root2.right));		
	}
}
