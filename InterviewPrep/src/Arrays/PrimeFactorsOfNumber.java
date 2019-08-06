package Arrays;

public class PrimeFactorsOfNumber {
	
	public void primeFactors(int num) {
		//print all 2's until its even
		while(num % 2 == 0) {
			System.out.println(2);
			num = num/2;
		}
		
		// at this point it will be odd
		for(int i=3;i<Math.sqrt(num);i+=2) {
			while(num % i == 0) {
				System.out.println(i);
				num = num/i;
			}
		}
		
		if(num>2)
			System.out.println(num);
	}
}
