package Design;

public class CircularBuffer {
	int capacity;
	int length = 0;
	int rear, front;
	int[] a;
	
	public CircularBuffer(int capacity, int[] a) {
		this.capacity = capacity;
		this.a = new int[capacity];
	}
	
	// when push, you increment rear anyways, you increment front only when array is full
	public void push(int num) {
		if(length < capacity) {
			length++;
		}
		else 
		{
			front = (front+1) % capacity;
		}
		a[rear] = num;
		rear = (rear+1) % capacity;
	}
	
	// when pop, you remove the front and increment only front. rear stays
	public int pop() {
		if(length > 0) {
			int temp = a[front];
			front = (front+1) % capacity;
			length--;
			return temp;
		}
		return -1;
	}
	
}
