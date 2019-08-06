package Medium;

public class JumpsGame {
	public int jumps(int arr[]) {
		if(arr.length == 0)
			return 0;
		
		int[] jump = new int[arr.length];
		jump[0] = 0;
		
		for(int i=1;i<arr.length;i++) {
			//initialize the jump value to Integer.MAX 
			jump[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				// check if element at j will cross ith value.
				if(i <= j+arr[j] && jump[j] != Integer.MAX_VALUE) {
					jump[i] = Math.min(jump[i], jump[j]+1);
					break;
				}
			}
		}
		return jump[arr.length-1];
	}
}
