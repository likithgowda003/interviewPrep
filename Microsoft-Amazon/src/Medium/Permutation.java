package Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public static void main(String[] args) 
    { 
        String str = "ABC"; 
        int n = str.length(); 
        permute(str, 0, n-1); 
    }

	private static void permute(String str, int l, int r) {
		if(l==r)
			System.out.println(str);
		else 
		{
			for(int i=l;i<=r;i++) {
				str = swap(str, l, i);
				permute(str, l+1, r);
				str = swap(str, l, i);
			}
		}
	}

	private static String swap(String str, int i, int j) {
		char[] ch = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return String.valueOf(ch);
	} 
	
	
	
	//distinct permutations of a string
	private static void distinctpermute(char[] str, int l, int r) {
		if(l==r)
			System.out.println(str);
		
		for(int i=l;i<=r;i++) {
			boolean check = shouldSwap(str,l,i);
			if(check)
			{
				str = swap1(str, l, i);
				distinctpermute(str, l+1, r);
				str = swap1(str, l, i);
			}
		}
	}

	
	private static boolean shouldSwap(char[] str, int l, int cur) {
		for(int i=l;i<cur;i++) {
			if(str[i] == str[cur])
				return false;
		}
		return true;
	}
	
	
	private static char[] swap1(char[] str, int l, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	// array permutaion
	public List<List<Integer>> permute1(int[] num){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(num,res,0);
		return res;
	}

	private void helper(int[] num, List<List<Integer>> res, int start) {
		// TODO Auto-generated method stub
		if(start == num.length-1)
		{
			List<Integer> list = new ArrayList<Integer>();
			for(int n: num) {
				list.add(n);
			}
			res.add(list);
			return;
		}
		
		for(int i=start; i<num.length;i++) {
			swapInt(num, start, i);
			helper(num, res, start+1);
			swapInt(num, start, i);
		}
		
	}

	private void swapInt(int[] num, int start, int i) {
		// TODO Auto-generated method stub
		int temp = num[start];
		num[start] = num[i];
		num[i] = temp;		
	}
	
}
