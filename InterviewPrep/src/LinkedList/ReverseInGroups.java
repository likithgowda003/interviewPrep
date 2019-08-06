package LinkedList;

public class ReverseInGroups {
	
	Node reverse(Node head, int k)
    {
       Node current = head;
       Node next = null;
       Node prev = null;
        
       int count = 0;
 
       /* Reverse first k nodes of linked list */
       while (count < k && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
       }
 
       /* next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
       if (next != null) 
          head.next = reverse(next, k);
 
       // prev is now head of input list
       return prev;
    } 
	
	
	// recursive reversal
	
	// initial prev is passed null value
	
	Node head;
	Node reverseRecursive(Node cur, Node prev) {
		
		if(cur.next == null) {
			head = cur;
			cur.next = prev;
			return head;
		}
		
		Node next = cur.next;
		cur.next = prev;
		
		reverseRecursive(next, cur);
		return head;
	}
}
