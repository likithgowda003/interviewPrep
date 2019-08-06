package Hard;

import java.util.LinkedList;

public class SlidingWindowMax {

	public static void main(String[] args) {
		int [] arr = {12, 1, 78, 90, 57, 89, 56};
		slidingwindow(arr,3);
	}

	private static int[] slidingwindow(int[] arr, int k) {
		if(arr.length == 0)
			return null;
		
		LinkedList<Integer> queue = new LinkedList<>();
		int[] result = new int[arr.length-k+1];
		
		for(int i=0;i<arr.length;i++) {
			
			// remove the front of the window as the window advances (queue.peekfirst() gives u the index of the first element)
			if(!queue.isEmpty() && queue.peekFirst() == i-k) {
				queue.poll();
			}
			
			// if the current element is greater than the last ele in the queue, remove the last element
			while(!queue.isEmpty() && arr[queue.peekLast()] < arr[i]) {
				queue.pollLast();				
			}
			
			queue.add(i);
			
			// store max elements only after k elements
			if(i+1 >= k) {
				result[i-k+1] = arr[queue.peek()];
			}
		}
		return result;
	}

}
