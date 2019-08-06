package Easy;

public class CalculatePower {
	
	public int power(int x, int y) {
		if(y==0)
			return 1;
		
		if(y==1)
			return x;
		
		else if(y%2 == 0)
			return power(x,y/2) * power(x,y/2);
		else
			return power(x,y/2) * power(x,y/2) * x;
	}
	
}
