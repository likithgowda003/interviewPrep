package Heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//We can use a min heap to solve this problem. 
//The heap stores the top k elements. Whenever the size is greater than k, delete the min. 
//Time complexity is O(nlog(k)). Space complexity is O(k) for storing the top k numbers.
public class kthlargest {
	
	public int kthlasrgest(int a[], int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		
		for(Integer i : a) {
			q.add(i);
			
			// remove the smallest element when queue size exceeds k
			if(q.size() >= k) {
				q.poll();
			}				
		}
		
		// return the head of the queue, by this time it would have removed all the smaller elements compared to this(cur head element)
		return q.peek();
	}
	
	
	
	
	// get k most frequent words in a sentence seperated by space
	//The idea is to keep a count of each word in a HashMap and then insert in a Priority Queue.
	//While inserting in pq, if the count of two words is same then insert based on string compare of the keys.

	    public List<String> topKFrequent(String[] words, int k) {
	        
	        List<String> result = new LinkedList<>();
	        Map<String, Integer> map = new HashMap<>();
	        for(int i=0; i<words.length; i++)
	        {
	            if(map.containsKey(words[i]))
	                map.put(words[i], map.get(words[i])+1);
	            else
	                map.put(words[i], 1);
	        }
	        
	        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
	                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
	        );
	        
	        for(Map.Entry<String, Integer> entry: map.entrySet())
	        {
	            pq.offer(entry);
	            if(pq.size()>k)
	                pq.poll();
	        }

	        while(!pq.isEmpty())
	            result.add(0, pq.poll().getKey());
	        
	        return result;
	    }
}
