package Arrays;

//We say that an element arr[x] is a local minimum if it is less than or equal to both its neighbors.
public class LocalMinima {
	public int localminima(int a[], int low, int high) {
		int mid = (low+high)/2;
		
		if((mid == 0 || a[mid-1] > a[mid]) && (mid == a.length-1 || a[mid] < a[mid+1]))
			return mid;
		
		else if(mid > 0 && a[mid-1] < a[mid])
			return localminima(a, low, mid-1);
		
		return localminima(a, mid+1, high);
	}
}
