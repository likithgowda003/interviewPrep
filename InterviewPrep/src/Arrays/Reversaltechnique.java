package Arrays;

public class Reversaltechnique {

	// if you want to rotate an array or linked list by d elements
	// use reversal algorithm
	// reverse first d elements
	// reverse the rest of them
	// reverse the entire array/linkedlist
	
	public void rotate(int[] a, int d) {
		int n = a.length;
		
		reverse(a, 0, d-1);
		reverse(a, d, n-1);
		reverse(a, 0, n-1);
	}


	private int[] reverse(int[] a, int strt, int end) {
		while(strt < end) {
			int temp = a[strt];
			a[strt] = a[end];
			a[end] = temp;
			strt++;
			end--;
		}	
		return a;
	}

}
