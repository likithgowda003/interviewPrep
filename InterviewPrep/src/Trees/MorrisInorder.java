package Trees;

import java.util.Stack;

public class MorrisInorder {
	 void MorrisTraversal(Tree root) {
	        Tree current, pre;
	          
	        if (root == null)
	            return;
	          
	        current = root;
	        while (current != null) 
	        {
	            if (current.left == null) 
	            {
	                System.out.print(current.data + " ");
	                current = current.right;
	            }
	            else
	            {
	                /* Find the inorder predecessor of current */
	                pre = current.left;
	                while (pre.right != null && pre.right != current) 
	                    pre = pre.right;
	                 
	                /* Make current as right child of its inorder predecessor */
	                if (pre.right == null) 
	                {
	                    pre.right = current;
	                    current = current.left;
	                } 
	  
	                 /* Revert the changes made in if part to restore the 
	                    original tree i.e.,fix the right child of predecssor*/
	                 else
	                 {
	                    pre.right = null;
	                    System.out.print(current.data + " ");
	                    current = current.right;
	                }   /* End of if condition pre->right == NULL */
	                  
	            } /* End of if condition current->left == NULL*/
	              
	        }
	 }
	 
	 
	 
	 // iterative inorder traversal
	 void iterative(Tree root) {
		 
		 Stack<Tree> s = new Stack<Tree>();
		 Tree cur = root;
		 
		 // push all elements to stack until left is null
		 while(cur!=null || !s.isEmpty()) {
			 while(cur!=null) {
				 s.push(cur);
				 cur = cur.left;
			 }
			 // pop the stack top if left is null, print and go right
			 cur = s.pop();
			 System.out.println(cur.data);
			 cur = cur.right;
		 }
	 }
}
