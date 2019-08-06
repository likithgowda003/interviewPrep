package Stack;

import java.util.Stack;

public class EvaluateExpression {
	
	public int evaluate(String str) {
		if(str.length() == 0)
			return 0;
		// value stack
		Stack<Integer> values = new Stack<Integer>();
		//operations stack
		Stack<Character> ops = new Stack<Character>();
		
		for(int i=0;i<str.length();i++) {
			
			// if its a number, add it to values stack
			if(str.charAt(i) >= '0' && str.charAt(i) <='9') {
				StringBuilder sb = new StringBuilder();
				while(i<str.length() && str.charAt(i) >= '0' && str.charAt(i) <='9') {
					sb.append(str.charAt(i));
					i++;
				}
				values.push(Integer.parseInt(sb.toString()));
			}
			
			else if(str.charAt(i) == '(') {
				ops.push(str.charAt(i));
			}
			
			else if(str.charAt(i) == ')') {
				while(ops.peek() != '(') {
					values.push(applyOps(ops.pop(), values.pop(), values.pop()));
				}
				ops.pop();
			}
			
			else if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
				while(!ops.isEmpty() && hasPrecedence(str.charAt(i), ops.peek())) {
					values.push(applyOps(ops.pop(), values.pop(), values.pop()));
				}
				ops.push(str.charAt(i));
			}
			
			while(!ops.isEmpty()) {
				values.push(applyOps(ops.pop(), values.pop(), values.pop()));
			}
		}
		return values.pop();
	}

	private boolean hasPrecedence(char op1, char op2) {
		// TODO Auto-generated method stub
		if(op2 == '(' || op2 == ')')
			return false;
		if((op1 == '/' || op1 == '*') && (op2 == '+' || op2 == '-'))
			return false;
		
		return true;
	}

	private Integer applyOps(char op, int a, int b) {
		// TODO Auto-generated method stub
		switch(op) {
			case '+': return a+b;
			case '-': return a-b;
			case '*': return a*b;
			case '/': return a/b;	
		default: return 0;
		}
	}
}
