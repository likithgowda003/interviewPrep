package Stack;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
	}

	private static void printNGE(int[] arr, int n) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack();
		int top,cur;
		
		s.push(arr[0]);
		
		for(int i=1;i<arr.length;i++) {
			cur = arr[i];
			
			if(!s.isEmpty()) {
				top = s.pop();
				
				while(cur > top) {
					System.out.println(top + " ==> " + cur);
					if(s.isEmpty())
						break;
					top = s.pop();
				}
				
				if(cur < top) {
					s.push(top);
				}
			}
			s.push(cur);
		}
		while (!s.isEmpty()) 
        {
			top = s.pop();
            cur = -1;
            System.out.println(top + " ==> " + cur);
        }
	}

}
