package Trees;

public class PairWithGivenSumBST {

	//METHOD-1
	//create an auxiliary array and store Inorder traversal of BST in the array. 
	//The array will be sorted as Inorder traversal of BST always produces sorted data. 
	//Once we have the Inorder traversal, we can pair in O(n) time
	
	
	//METHOD-2
	// The idea was to first in-place convert BST to Doubly Linked List (DLL), then find pair in sorted DLL in O(n) time. 
	//This solution takes O(n) time and O(Logn) extra space, but it modifies the given BST.
	
	
	//METHOD-3
	//The idea is same as finding the pair in sorted array (See method 1 of this for details).
	//We traverse BST in Normal Inorder and Reverse Inorder simultaneously. In reverse inorder, 
	//we start from the rightmost node which is the maximum value node. In normal inorder, 
	//we start from the left most node which is minimum value node. We add sum of current nodes in both 
	//traversals and compare this sum with given target sum. If the sum is same as target sum, we return true. 
	//If the sum is more than target sum, we move to next node in reverse inorder traversal, 
	//otherwise we move to next node in normal inorder traversal. 
	//If any of the traversals is finished without finding a pair, we return false. 
}
