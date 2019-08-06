package Medium;

/*
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters 
 * counting from the start of the string. If there are less than k characters left, reverse all of them. 
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters 
 * and left the other as original.
 */
public class ReverseString {
	
	public String reverseStr(String s, int k) {
		char[] arr = s.toCharArray();
		int i=0;
		while(i<arr.length) {
			int j = Math.min(i+k-1, arr.length-1);
			swap(arr,i,j);
			i=i+2*k;
		}
		return String.valueOf(arr);
	}

	private void swap(char[] arr, int i, int j) {
		while(i<j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	
	
	// str = "i like this program very much"
		public void reverse(String str) { 
	    String s[]=str.split(" "); 
	    String ans=""; 
	    for(int i=s.length - 1; i >= 0; i--) { 
	        ans+=s[i]+" ";         
	    } 
	    System.out.println("Reversed String:"); 
	    System.out.println(ans.substring(0,ans.length()-1)); 
	      
	 } 
		
		
		
	// inplace reverse string
	// reverse each word if you find a space 
	// then reverse the entire sentence
		
		public void reverseWords(char[] s) {
		    int i=0;
		    for(int j=0; j<s.length; j++){
		        if(s[j]==' '){
		            reverse(s, i, j-1);        
		            i=j+1;
		        }
		    }	 	
		    reverse(s, i, s.length-1);		 
		    reverse(s, 0, s.length-1);
		}
		 
		public void reverse(char[] s, int i, int j){
		    while(i<j){
		        char temp = s[i];
		        s[i]=s[j];
		        s[j]=temp;
		        i++;
		        j--;
		    }
		}
}




	