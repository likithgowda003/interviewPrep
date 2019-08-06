package Trees;

public class MorrisPreOrder {

	void morrisTraversalPreorder(Tree node) {
		if(node == null)
			return;
		
		while(node != null) {
			if(node.left == null) {
				System.out.println(node.data);
				node = node.right;
			}
			else
			{
				Tree cur = node.left;
				while(cur.right != null && cur.right != node) {
					cur = cur.right;
				}
				
				if(cur.right == null) {
					System.out.println(node.data);
					cur.right = node;
					node = node.left;
				}
				else {
					cur.right = null;
					node = node.right;
				}
			}
		}
	}
}
