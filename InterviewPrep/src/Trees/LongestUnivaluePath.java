package Trees;

public class LongestUnivaluePath {
	int len = 0;
	int longestpath(Tree root) {
		if(root == null)
			return 0;
		getlength(root,root.data);
		return len;
	}

	private int getlength(Tree root, int data) {
		if(root == null)
			return 0;
		
		int left = getlength(root.left, data);
		int right = getlength(root.right, data);
		
		len = Math.max(len, left+right);
		if(data == root.data)
			return Math.max(left, right) + 1;
		
		return 0;
	}
}
