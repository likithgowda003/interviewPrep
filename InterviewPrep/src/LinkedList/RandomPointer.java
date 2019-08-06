package LinkedList;

public class RandomPointer {
	
	public Node random(Node head) {
		
		Node cur = head;
		Node temp = null;
		while(cur != null) {
			cur.next = temp;
			//insert new node
			cur.next = new Node(cur.data);
			cur.next.next = temp;
			cur = temp;
		}
		cur = head;
		
		// assign random pointer
		while(cur!=null) {
			cur.next.random = cur.random != null ? cur.random.next : cur.random;
			cur = cur.next != null ? cur.next.next : cur.next; 
		}
		cur = head;
		
		// seperate org and copy list
		Node org = cur;
		Node copy = cur.next;
		Node copy_head = copy; // keep track of the head of copy list
		while(org != null && copy != null) {
			org.next = org.next != null ? org.next.next : org.next;
			copy.next = copy.next != null ? copy.next.next : copy.next;
			org = org.next;
			copy = copy.next;
		}
		return copy_head;
	}
}
