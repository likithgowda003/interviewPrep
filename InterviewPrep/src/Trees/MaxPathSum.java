package Trees;

public class MaxPathSum {

	// root to leaf path sum
	public boolean PathSumFromRootToLeaf(Tree root, int sum) {
		if(root == null)
			return (sum == 0);
		
		if(root.left == null && root.right == null && sum == root.data)
			return true;
		
		return PathSumFromRootToLeaf(root.left, sum - root.data) || PathSumFromRootToLeaf(root.right, sum-root.data);
	}
	
	
	// maixmum pathsum
	// res = Integer.MinValue initially
	static int res = Integer.MIN_VALUE;
	
	public int MaxPathSum(Tree root) {
		if(root == null)
			return 0;
		
		int l = MaxPathSum(root.left);
		int r = MaxPathSum(root.right);

		int max_single = Math.max((Math.max(l,r)+root.data), root.data);
		int max_top = Math.max(max_single, l+r+root.data);
		res =  Math.max(res, max_top);
		
		return max_single;
	}
}
