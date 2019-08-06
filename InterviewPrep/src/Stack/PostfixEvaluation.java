package Stack;

import java.util.Stack;

public class PostfixEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(exp));
	}

	private static int evaluatePostfix(String exp) {
		// TODO Auto-generated method stub
		
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i=0;i<exp.length();i++) {
			char c = exp.charAt(i);
			
			if(c==' ')
				continue;
			
			else if(Character.isDigit(c)) {
				int n = 0;
				// convert character into number ('100' => 100)
				while(Character.isDigit(c)) {
					n = n * 10 + (int) (c-'0');
					i++;
					c = exp.charAt(i); 
				}
				i--;
				s.push(n);
			}
			else {
				int val1 = s.pop();
				int val2 = s.pop();
				
				switch(c)
				{
				case '+': s.push(val1+val2);
				break;
				case '-': s.push(val1-val2);
				break;
				case '*': s.push(val1*val2);
				break;
				case '/': s.push(val1/val2);
				break;
				}
			}
		}
		return s.pop();
	}

}
