package Arrays;

public class FindRepeatingAndMissing {
	
	public void repeat(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int abs_val = Math.abs(arr[i]);
			if(arr[abs_val - 1] > 0)
				arr[abs_val - 1] = -arr[abs_val - 1];
			else
				System.out.println("repeated");
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > 0)
				System.out.println("missing"+ i+1);
		}
	}
}
