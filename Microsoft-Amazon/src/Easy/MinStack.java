package Easy;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	void push(int x){
		// push element to minStack only if it is empty or less than top element of minStack
		if(minStack.isEmpty() || x < minStack.peek()) {
			minStack.push(x);
		}
		stack.push(x);
	}
	
	int pop() {
		// if an element is being poped, check if it is the min element
		// if yes, then pop that from the minStack
		if(stack.peek() == minStack.peek()){
			minStack.pop();
		}
		return stack.pop();
	}
	
	int top() {
		return stack.peek();
	}
	
	int getMin() {
		return minStack.peek();
	}
}
