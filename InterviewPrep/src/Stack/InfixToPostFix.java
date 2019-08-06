package Stack;

import java.util.Stack;

public class InfixToPostFix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
	}

	private static String infixToPostfix(String exp) {
		// TODO Auto-generated method stub
		
		String res ="";
		Stack<Character> s = new Stack();
		
		for(int i=0;i<exp.length();i++) {
			// if its a letter
			if(Character.isLetterOrDigit(exp.charAt(i))) 
				res += exp.charAt(i);
			
			else if(exp.charAt(i) == '(')
				s.push(exp.charAt(i));
			
			else if(exp.charAt(i) == ')') {
				while(!s.isEmpty() && s.peek() != '(') {
					res += s.pop();
				}
				if(!s.isEmpty() && s.peek() != '(')
					return "Invalid Expression"; // invalid expression                
	             else
	                 s.pop();
			}
			
			else {
				while (!s.isEmpty() && Prec(exp.charAt(i)) <= Prec(s.peek()))
                    res += s.pop();
                s.push(exp.charAt(i));
			}
		}
		
		while (!s.isEmpty())
            res += s.pop();
      
		
		return res;
	}
	
	static int Prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
      
        case '*':
        case '/':
            return 2;
      
        case '^':
            return 3;
        }
        return -1;
    }

}
