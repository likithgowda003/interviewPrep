package Easy;

// count number of 5's
public class TrailingZeroes {
	public int trailingzeroes(int n) {
		int temp = 5;
		int count = 0;
		
		while(temp < n) {
			count = count + n/temp;
			temp = temp * 5;
		}
		return count;
	}
}
