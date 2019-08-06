package Arrays;

//Input: [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
public class SortColorsInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,0,2,1,1,0};
		sort(arr);

	}

	// keep track of start and end.
	// if arr element is 0 exchange with start, start++
	// iff arr element is 2 exchange with end, end--
	// if arr element is 1, do nothing
	
	private static void sort(int[] arr) {
		// TODO Auto-generated method stub
		
		int j=0, k=arr.length-1;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 0) {
				swap(arr[i], arr[j]);
				j++;
			}
			else if(arr[i] == 2) {
				swap(arr[i], arr[k]);
				i--;
				k--;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}

	private static void swap(int i, int j) {
		// TODO Auto-generated method stub
		int temp = i;
		i = j;
		j = temp;
		
	}

}
