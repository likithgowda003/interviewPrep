package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//given [3, 30, 34, 5, 9], the largest formed number is 9534330
public class GreatestNumber {

	public static void main(String[] args) {
		int arr[] = {3, 30, 34, 5, 9};
		System.out.println(greatestnum(arr));
	}
	
	
	public static String greatestnum(int[] arr) {
		
		String[] string_arr = new String[arr.length];	
		for(int i=0;i<arr.length;i++) {
			string_arr[i] = String.valueOf(arr[i]);
		}
		
		Arrays.sort(string_arr, new Comparator<String>() {
			public int compare(String x, String y) {
				return (y+x).compareTo(x+y);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String s : string_arr) {
			sb.append(s);
		}
		
		while(sb.charAt(0)=='0' && sb.length()>1) {
			sb.deleteCharAt(0);
		}
		
		return sb.toString();
	}
	
}
