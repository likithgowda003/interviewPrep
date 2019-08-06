package Trees;

import java.util.ArrayList;

public class MergeTwoBalancedBST {
	public Tree mergertrees(Tree root1, Tree root2) {
		ArrayList<Integer> list1 = storeInorder(root1);
		ArrayList<Integer> list2 = storeInorder(root2);
		ArrayList<Integer> list3 = merge(list1, list2);
		Tree root = ALtoBST(list3, 0, list3.size()-1);
		return root;
	}


	private ArrayList<Integer> storeInorder(Tree root1) {
		ArrayList<Integer> list1 = new ArrayList<>(); 
        ArrayList<Integer> list2 = storeInorderUtil(root1,list1); 
        return list2;
	}
	
	
	private ArrayList<Integer> storeInorderUtil(Tree node, ArrayList<Integer> list) {
		 if(node == null)
	            return list;
	         
	        //recur on the left child
	        storeInorderUtil(node.left, list);
	         
	        // Adds data to the list
	        list.add(node.data);
	         
	        //recur on the right child
	        storeInorderUtil(node.right, list);
	         
	        return list;	
	}


	private ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> list3 = new ArrayList<>();
        int i=0;
        int j=0;
        int m = list1.size();
        int n = list2.size();
         
        //Traversing through both ArrayLists
        while( i<m && j<n)
        {
            // Smaller one goes into list3
            if(list1.get(i)<list2.get(j))
            {
                list3.add(list1.get(i));
                i++;
            }
            else
            {
                list3.add(list2.get(j));
                j++;
            }
        }
         
        // Adds the remaining elements of list1 into list3
        while(i<m)
        {
            list3.add(list1.get(i));
            i++;
        }
     
        // Adds the remaining elements of list2 into list3
        while(j<n)
        {
            list3.add(list2.get(j));
            j++;
        }
        return list3;
	}
	
	
	private Tree ALtoBST(ArrayList<Integer> list3, int start, int end) {
		 if(start > end)
	            return null;
	     
	        // Get the middle element and make it root   
	        int mid = (start+end)/2;
	        Tree node = new Tree(list3.get(mid));
	 
	        /* Recursively construct the left subtree and make it
	        left child of root */
	        node.left = ALtoBST(list3, start, mid-1);
	         
	        /* Recursively construct the right subtree and make it
	        right child of root */
	        node.right = ALtoBST(list3, mid+1, end);
	     
	    return node;
	}
}
