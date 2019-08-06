package Trees;

import java.util.Stack;

public class ZigzagTraversal {

	
	// recursive approach
	/* printGivenLevel(tree, level, ltr)
		if tree is NULL then return;
		if level is 1, then
    			print(tree->data);
		else if level greater than 1, then
    		if(ltr)
        		printGivenLevel(tree->left, level-1, ltr);
        		printGivenLevel(tree->right, level-1, ltr);
    		else
        		printGivenLevel(tree->right, level-1, ltr);
        		printGivenLevel(tree->left, level-1, ltr);
*/
	
	int height(Tree node) 
    {
        if (node == null) 
            return 0;
        else
        {
              
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);
  
            /* use the larger one */
            if (lheight > rheight) 
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
	void printSpiral(Tree node) 
    {
        int h = height(node);
        int i;
  
        /* ltr -> left to right. If this variable is set then the
           given label is transversed from left to right */
        boolean ltr = false;
        for (i = 1; i <= h; i++) 
        {
            printGivenLevel(node, i, ltr);
  
            /*Revert ltr to traverse next level in opposite order*/
            ltr = !ltr;
        }
  
    }
	
	void printGivenLevel(Tree node, int level, boolean ltr) 
    {
        if (node == null) 
            return;
        if (level == 1) 
            System.out.print(node.data + " ");
        else if (level > 1) 
        {
            if (ltr != false) 
            {
                printGivenLevel(node.left, level - 1, ltr);
                printGivenLevel(node.right, level - 1, ltr);
            } 
            else
            {
                printGivenLevel(node.right, level - 1, ltr);
                printGivenLevel(node.left, level - 1, ltr);
            }
        }
    }
	
	
	
	
	
	
	// iterative approach
	
	void printSpiral1(Tree node) 
    {
        if (node == null) 
            return;   // NULL check
 
        // Create two stacks to store alternate levels
        Stack<Tree> s1 = new Stack<Tree>();// For levels to be printed from right to left
        Stack<Tree> s2 = new Stack<Tree>();// For levels to be printed from left to right
 
        // Push first level to first stack 's1'
        s1.push(node);
 
        // Keep ptinting while any of the stacks has some nodes
        while (!s1.empty() || !s2.empty()) 
        {
            // Print nodes of current level from s1 and push nodes of
            // next level to s2
            while (!s1.empty()) 
            {
            		Tree temp = s1.pop();
                System.out.print(temp.data + " ");
 
                // Note that is right is pushed before left
                if (temp.right != null) 
                    s2.push(temp.right);
                 
                if (temp.left != null) 
                    s2.push(temp.left);
                 
            }
 
            // Print nodes of current level from s2 and push nodes of
            // next level to s1
            while (!s2.empty()) 
            {
            		Tree temp = s2.pop();
                System.out.print(temp.data + " ");
 
                // Note that is left is pushed before right
                if (temp.left != null)
                    s1.push(temp.left);
                
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }
}
