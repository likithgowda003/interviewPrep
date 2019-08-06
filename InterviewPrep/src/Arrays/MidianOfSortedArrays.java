package Arrays;

public class MidianOfSortedArrays {
	
	public double median(int[] input1, int[] input2) {
        
		//if input1 length is greater than switch them so that input1 is smaller than input2.
		if(input1.length > input2.length)
			return median(input2, input1);
		
		int x = input1.length;
		int y = input2.length;
		
		int low = 0;
		int high = x;
		
		while(low<=high) {
			int partitionX = (low+high)/2;
			int partitionY = (x + y + 1)/2 - partitionX;
			
			//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE : input1[partitionX-1];
			int minRightX = (partitionX == x)? Integer.MAX_VALUE : input1[partitionX];
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE :input1[partitionY-1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input1[partitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				//We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
				if((x + y) % 2 == 0) {
					return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else {
					return (double) (Math.max(maxLeftX, maxLeftY));
				}
			}
			else if(maxLeftX > minRightY) //we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			else
				low = partitionX + 1; //we are too far on left side for partitionX. Go on right side.
		}
		return -1;
	}
}
