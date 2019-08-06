package LinkedList;

public class Node {
	int data;
	Node next;
	Node random;
	
	public Node(int data, Node next) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = next;
	}
	
	public Node(int data, Node next, Node random) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = next;
		this.random = random;
	}
	
	public Node getRandom() {
		return random;
	}

	public void setRandom(Node random) {
		this.random = random;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	public Node(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
