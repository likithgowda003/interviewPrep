;package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

import Easy.Node;

public class MergeKSortedList {
	
	public Node mergeklist(Node[] lists) {
		
		if(lists == null)
			return null;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.getData() - n2.getData();
			}
		});
		
		Node head = new Node(0);
		Node p = head;
		
		// add the head nodes of all the linked lists onto heap
		for(Node list : lists) {
			if(list!=null)
				queue.offer(list);
		}
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			p.getNext() = n;
			p = p.getNext();
			
			if(n.next!=null)
	            queue.offer(n.next);
		}
		
		return head.getNext();
	}
}
