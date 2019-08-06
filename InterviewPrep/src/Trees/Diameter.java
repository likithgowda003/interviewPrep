package Trees;

public class Diameter {
	public int diameter(Tree root) {
		if(root == null)
			return 0;
		
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		
		return Math.max(lheight+rheight+1, Math.max(ldiameter, rdiameter));
	}

	private int height(Tree root) {
        if(root == null)
        		return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
	}
}
