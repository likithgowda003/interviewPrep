package Arrays;

// sort in wave form
// Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
// Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
// {20, 5, 10, 2, 80, 6, 100, 3} OR
// any other array that is in wave form

public class WiggleSort {
	void swap(int arr[], int a, int b) 
    { 
        int temp = arr[a]; 
        arr[a] = arr[b]; 
        arr[b] = temp; 
    } 
  
    // This function sorts arr[0..n-1] in wave form, i.e., 
    // arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4].... 
    void sortInWave(int arr[], int n) 
    { 
        // Traverse all even elements 
        for (int i = 0; i < n; i+=2) 
        { 
            // If current even element is smaller 
            // than previous 
            if (i>0 && arr[i-1] > arr[i] ) 
                swap(arr, i-1, i); 
  
            // If current even element is smaller 
            // than next 
            if (i<n-1 && arr[i] < arr[i+1] ) 
                swap(arr, i, i + 1); 
        } 
    } 
}
