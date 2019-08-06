package Arrays;

public class MaxDiff {

	int maxdiff(int[] arr) {
		int max_diff = arr[1] - arr[0];
		int cur_min = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i] - cur_min > max_diff)
				max_diff = arr[i] - cur_min;
			if(arr[i] < cur_min)
				cur_min = arr[i];
		}
		return max_diff;
	}

}
