package Trees;

public class BinaryTreePathRootToLeaf {
	
	void printPath(Tree root) {
		int[] arr = new int[20];
		helper(root, arr, 0);
	}

	private void helper(Tree root, int[] arr, int i) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		
		arr[i] = root.data;
		
		if(root.left == null && root.right == null) {
			printArray(arr);
		    return;
		}
		
		helper(root.left, arr, i++);
		helper(root.right, arr, i++);
	}

	private void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	}
}
