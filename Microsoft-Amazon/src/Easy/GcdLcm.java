package Easy;

public class GcdLcm {
	
	public int gcd(int a, int b) {
		if(b==0)
			return a;
		
		return gcd(b, a%b);
	}
	
	// method to return LCM of two numbers 
    public int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    } 

	
	
	
	
	
	
	// Function to find gcd of array of 
    // numbers 
     int findGCD(int arr[], int n) 
    { 
        int result = arr[0]; 
        for (int i = 1; i < n; i++) 
            result = gcd(arr[i], result); 
  
        return result; 
    } 
     
	 int gcd1(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
	 
	 
	 
	 
	 
	 
	 
  
    
}
