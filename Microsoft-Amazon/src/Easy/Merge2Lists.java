package Easy;

public class Merge2Lists {
	Node merge(Node n1, Node n2) {
		
		if(n1==null)
			return n2;
		
		if(n2 == null)
			return n1;
		
		if(n1.data < n2.data) {
			n1.next = merge(n1.next, n2);
			return n1;
		}
		else
		{
			n2.next = merge(n1, n2.next);
			return n2;
		}
	}
}
