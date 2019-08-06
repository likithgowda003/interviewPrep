package DynamicProgramming;

public class EggFloor {
	
	int egg_drop(int floors, int eggs)
	{
	  // Base case
	  if (floors == 0 || floors == 1 || eggs == 1)
	  {
	    return floors;
	  }
	  
	  // Keep track of the MINIMUM number of drops needed
	  int min_drops = INT_MAX;
	  
	  // Consider each drop from first to current floor
	  for (int i = 1; i <= floors; i++)
	  {
	    // If the egg breaks on floor x, we only need to test floors up to the
	    // x-1th floor. We also have one less egg since the egg broke.
	    int egg_break = egg_drop(i - 1, eggs - 1);
	    
	    // If the egg did not break on floor x, we only need to test floors 
	    // starting from the floor-xth floor onwards. The number of eggs 
	    // does not change since the egg did not break.  
	    int egg_not_break = egg_drop(floors - i, eggs);
	    
	    // Find the number of drops necessary in the WORST CASE scenario.
	    // Don't forget to add one to include the current drop.  
	    int drops = max(egg_break, egg_not_break) + 1;
	  
	    // Update memo[floor][egg] if we found a smaller number of needed 
	    // egg drops  
	    
	    min_drops = Math.min(drops, min_drops);
	    
	  }
	  
	  return min_drops;
	}
	
	
	
	
	
	public int eggdrop(int floors, int eggs) {
		int table[][] = new int[eggs+1][floors+1];
		int res;
		
		// fill first col with 0 and second col with 1
		// beacuse 0th floor requires 0 trials and 1 floor requires 1 trial
		for(int i=0;i<=floors;i++) {
			table[i][0] = 0;
			table[i][1] = 1;
		}
		
		// fill first row with jth value
		// because each floor requires 1 trial each for 1 egg
		for(int j=0;j<=floors;j++) {
			table[0][j] = j;
		}
		
		// fill rest of the table
		for(int e=2;e<=eggs;e++) {
			for(int f=2;f<floors;f++) {
				table[e][f] = Integer.MAX_VALUE;
				// floors under test until j floors
				for(int x=1;x<=f;x++) {
					res = 1 + Math.max(table[e-1][x-1], table[e][f-x]);
					table[e][f] = Math.min(table[e][f], res);
				}
			}
		}
		return table[floors][eggs];
	}
}
