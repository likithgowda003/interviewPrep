package Easy;

import java.util.ArrayList;

public class BuyAndSellStock {
	
	class Interval 
	{
	    int buy, sell;
	}
	
	void buysellstock(int[] price) {
		
		if(price.length == 1)
			return;
		
		int i=0,count=0;
        ArrayList<Interval> sol = new ArrayList<Interval>();

		
		while(i<price.length-1) {
			while(i<price.length-1 && price[i+1] <= price[i]) {
				i++;
			}
			
			if(i == price.length-1)
				break;
			
			Interval e = new Interval();
			e.buy = i++;
			
			while(i<price.length && price[i] >= price[i-1]) {
				i++;
			}
			e.sell = i-1;
			sol.add(e);
			count++;
		}
		
		if (count == 0)
            System.out.println("There is no day when buying the stock "
                                                  + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        +"        " + "Sell on day : " + sol.get(j).sell);
         
        return;
	}
}
