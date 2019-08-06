package Medium;

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
	
	public String simplifyPath(String path) {
		if(path == null)
			return null;
		
		// if last character is a '/'
		if(path.length() > 0 && path.charAt(path.length()-1) == '/') {
			path = path.substring(0, path.length()-1);
		}
		
		Stack<String> stack = new Stack<String>();
		int start = 0;
		
		for(int i=1;i<path.length();i++) {
			if(path.charAt(i) == '/') {
				stack.push(path.substring(start, i)); // push all the characters until '/'
				start = i;   // start will again point to '/'
			}
			else if(i == path.length()-1) {
				stack.push(path.substring(start));
			}
		}
		
		LinkedList<String> res = new LinkedList<String>();
		int back = 0;
		
		while(!stack.isEmpty()) {
			String top = stack.pop();
			
			if(top == "/." || top == "/") {
				//nothing
			}
			else if(top == "/..") {
				back++;
			}
			else {                 // if a directory is encountered, check if there was a '/..' encountered before (using back variable), if not push cur dir to res queue
				if(back > 0) {  
					back--;
				} else {
					res.push(top);
				}
			}
		}
		
		if(res.isEmpty())
			return "/";
		
		StringBuilder sb = new StringBuilder();
		while(!res.isEmpty()) {
			sb.append(res.pop());
		}
		
		return sb.toString();
	}
}
