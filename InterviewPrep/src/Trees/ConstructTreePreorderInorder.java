package Trees;

public class ConstructTreePreorderInorder {
	static int preIndex = 0;
	
	// preorder, inorder
	public static Tree  buildTree(int[] inorder, int[] preorder, int strt, int end){
		if(strt > end)
			return null;
		
		Tree root = new Tree(preorder[preIndex++]);
		
		/* If this node has no children then return */
		if(strt == end)
			return root;
		
		int index = search(inorder, strt, end, root.data);
		
		root.left = buildTree(inorder, preorder, strt, index-1);
		root.right = buildTree(inorder, preorder, index+1, end);
		
		return root;
	}
	
//======================================================================================================================
	// inorder postorder
	public Tree buildutil(int[] inorder, int[] postorder, int strt, int end) {
		int postIndex = inorder.length-1;
		return buildTree1(inorder, postorder, strt, end, postIndex);
	}
	
	public static Tree  buildTree1(int[] inorder, int[] preorder, int strt, int end, int postIndex){
		if(strt > end)
			return null;
		
		Tree root = new Tree(preorder[postIndex--]);
		
		/* If this node has no children then return */
		if(strt == end)
			return root;
		
		int index = search(inorder, strt, end, root.data);
		
		root.left = buildTree1(inorder, preorder, strt, index-1, postIndex);
		root.right = buildTree1(inorder, preorder, index+1, end, postIndex);
		
		return root;
	}
	
	
//=======================================================================================================================	
	private static int search(int[] inorder, int strt, int end, int data) {
		for(int i=strt; i<=end;i++) {
			if(inorder[i] == data)
				return i;
		}
		return -1;
	}
}
