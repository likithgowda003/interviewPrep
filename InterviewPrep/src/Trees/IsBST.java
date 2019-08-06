package Trees;

public class IsBST {
	
	public boolean IsBst(Tree root) {
		return IsBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean IsBstUtil(Tree root, int minValue, int maxValue) {
		if(root == null)
			return false;
		
		if(root.data < minValue || root.data > maxValue)
			return false;
		
		return IsBstUtil(root.left, minValue, root.data-1) && IsBstUtil(root.right, root.data+1, maxValue);
	}
}
