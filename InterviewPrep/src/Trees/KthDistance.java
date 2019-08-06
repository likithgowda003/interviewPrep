package Trees;

// https://www.geeksforgeeks.org/print-nodes-k-distance-root-iterative/
public class KthDistance {
	
	public static void main(String[] args) {
        
        /* Constructed binary tree is
                1
              /   \
             5     10
            /  \   / \
           3    7 8   12
        */
        Tree tree = new Tree(1);
        tree.left = new Tree(5);
        tree.right = new Tree(10);
        tree.left.left = new Tree(3);
        tree.left.right = new Tree(7);
        tree.right.left = new Tree(8);
        tree.right.right = new Tree(12);
  
        printKDistant(tree, 2);
	}
	
	public static void printKDistant(Tree node, int k) 
    {
        if (node == null)
            return;
        if (k == 0) 
        {
            System.out.print(node.data + " ");
            return;
        } 
        else
        {
            printKDistant(node.left, k - 1);
            printKDistant(node.right, k - 1);
        }
    }
}
