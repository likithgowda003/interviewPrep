package Medium;

//Print all subsets of given size of a set
public class SubsetOfGivenSize {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };
        int r = 3;
        printCombination(arr, r);
	}

	private static void printCombination(int[] arr, int r) {
		int data[] = new int[r];
		
		helper(arr, r, 0, 0, data);
	}

	private static void helper(int[] arr, int r, int i, int index, int[] data) {
		// break condition
		if(index == r) {
			for(int j=0;j<data.length;j++) {
				System.out.println(data[i]);
				return;
			}
		}
		
		// when all elements are done processing
		if(i>=arr.length)
			return;
		
		// put element into data array 
		// inserting element into data array at which index is decided by the below conditions
		data[index] = arr[i];
		
		// conditions
		// index  ---> Current index in data[]

		// including current element
		helper(arr, r, i+1, index+1, data);
		
		// excluding current element
		// when current index is excluded, the value at that index is replaced by another element
		helper(arr, r, i+1, index, data);	
	}
}
