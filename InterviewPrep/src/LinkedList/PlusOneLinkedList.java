package LinkedList;

public class PlusOneLinkedList {
	
	public Node plus(Node head) {
		// reverse list 
		Node h = reverse(head);
		Node n = h;
		
		while(n!=null) {
			if(n.data + 1 <= 9) {
				n.data = n.data + 1;
			}
			else
			{
				n.data = 0;
				if(n.next == null) {
					n.next = new Node(1);
				}
			}
			n = n.next;
		}
		return reverse(h);
	}
}
