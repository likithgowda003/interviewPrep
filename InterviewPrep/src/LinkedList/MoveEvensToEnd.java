package LinkedList;

public class MoveEvensToEnd {
	static Node tempEnd = null;
	
	public static void main(String[] args) {
		
//		Node head = new Node(6);
//		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = new Node(1);
//		head.next.next.next.next = new Node(4);
//		head.next.next.next.next.next = new Node(1);
//		head.next.next.next.next.next.next = new Node(9);
		
		Node head = new Node(2);
	     head.next = new Node(3);

		Node res = moveEvensToEnd(head);

		while(res!=null) {
			System.out.println(res.data);
			res = res.next;
		}
		
	}
	
	public static Node moveEvensToEnd(Node in) {

		if(in == null)
			return null;
		
		Node start = in;
		Node end = in;
		Node head = null;
	
		// set head and end pointers
		// head points to the first odd element encountered in the LinkedList
		while(end.next != null) 
		{ 	
			if(head == null && end.data % 2 != 0)
			{	
				head = end;
			}
			end = end.next;
		}

		// since the end will change if we add an even element to the end, we will have to 
		// maintain a temporary end pointer
		tempEnd = end;
	
		// check if all elements in the LinkedList are even
		if(head == null)
		return in;
			
			
		// link end of LinkedList to elements before head
		if(in != head)  //to check if the first element of the LinkedList if odd
		{
			tempEnd.next = in;
			while(tempEnd.next != head)
			{
				tempEnd = tempEnd.next;
			}
			tempEnd.next = null;	
		}
		
	
		Node previous = head;
		start = head.next;
	
		// move the node with even value encountered to the end of the list
		while(start != end)
		{
			if(start.data % 2 == 0)
			{
			 	Node next = start.next;
				tempEnd.next = start;
				tempEnd = start;
				tempEnd.next = null;
				start = next;
			   	previous.next = start;
			}
			else
			{
				previous = start;
				start = start.next;
			}
		}
		
		if(start == end && start.data % 2 == 0) {
			tempEnd.next = start;
			previous.next = start.next;
			start.next = null;
		}
		return head;	
	}
}
