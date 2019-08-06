package Trees;

// https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/

//We will maintain three pointers, first, middle and last. 
// When we find the first point where current node value is smaller than previous node value, 
// we update the first with the previous node & middle with the current node. 
// When we find the second point where current node value is smaller than previous node value, 
// we update the last with the current node. In case #2, we will never find the second point. 
// So, last pointer will not be updated. After processing, if the last node value is null, 
// then two swapped nodes of BST are adjacent.


public class SwapNodesToFormBST {
	private Tree first, middle, last, prev;
	
	public void swapnodes(Tree root) {
		middle=null;
		first=null;
		last=null;
		prev=null;
		
		// call helper method
		swapnodesutil(root);

		if(first != null && last != null) {
			Tree temp = first;
			first = last;
			last = temp;
		}
		else if(first!=null && middle != null) {
			Tree temp = first;
			first = middle;
			middle = temp;
		}		
	}

	private void swapnodesutil(Tree root) {
		if(root!=null) {
			
			// recur left subtree
			swapnodesutil(root.left);
			
			if(prev!=null && root.data < prev.data) {
				if(first == null) {
					first = prev;
					middle = root;
				}
				else
					last = root;
			}
			prev = root;
			
			// recur right subtree
			swapnodesutil(root.right);
		}
	}
}
