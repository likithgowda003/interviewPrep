package Arrays;

public class Merge2SortedArrays {

	public static void main(String[] args) {
		int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
		int arr2[] = new int[]{2, 3, 8, 13};
		merge(arr1,arr2);
	}

	private static void merge(int[] arr1, int[] arr2) {
		for(int i=arr2.length-1; i>=0;i--) {
			
			/* Find the smallest element greater than ar2[i]. Move all
            elements one position ahead till the smallest greater
            element is not found */
			int last = arr1[arr1.length-1];
			for(int j=arr1.length-2;j>=0 && arr1[j]>arr2[i];j--) {
				arr1[j+1] = arr1[j];
				
				// If there was a greater element
				if(j!=arr1.length-2 || last > arr2[i]) {
					arr1[j+1] = 	arr2[i];
					arr2[i] = last;
				}
			}
		}
	}
}
