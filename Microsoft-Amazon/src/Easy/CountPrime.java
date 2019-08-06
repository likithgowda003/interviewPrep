package Easy;

public class CountPrime {

	public int countPrimes(int n) {
		if (n <= 2)
			return 0;
	 
		// init an array to track prime numbers
		// fill bool array with True after index 2
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;
	 
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
		// or for (int i = 2; i <= n-1; i++) {
			//when a true is encountered got to its i+i index and make it false
			if (primes[i]) {
				for (int j = i + i; j < n; j += i)
					primes[j] = false;
			}
		}
	 
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}
	 
		return count;
	}
}
