package Trees;

public class BoundaryTraversal {
	
	public void boundaryTraversal(Tree root) {
		if(root != null) {
			System.out.println(root.data);
			printleft(root.left);
			printright(root.right);
			printleaf(root.left);
			printleaf(root.right);
		}
	}

	private void printleaf(Tree root) {
		// TODO Auto-generated method stub
		if(root != null) {
			if(root.left == null && root.right == null)
				System.out.print(root.data);
			
			printleaf(root.left);
			printleaf(root.right);
		}
		
	}
	
	private void printleft(Tree root) {
		// TODO Auto-generated method stub
		if(root != null) {
			if(root.left != null) {
				System.out.println(root.data);
				printleft(root.left);
			}
			else if(root.right != null) {
				System.out.println(root.data);
				printleft(root.right);
				
			}
		}
	}

	private void printright(Tree root) {
		// TODO Auto-generated method stub
		if(root != null) {
			if(root.right != null) {
				printright(root.right);
				System.out.println(root.data);
			}
			else if(root.left != null) {
				printright(root.left);
				System.out.println(root.data);
			}
		}
		
	}
}
