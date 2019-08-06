package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class DiffOddLevelEvenLevel {
	
	public int iterative(Tree root) {
		if(root == null)
			return 0;
		
		Queue<Tree> q = new LinkedList<Tree>();
		int level = 0;
		int oddSum=0, evenSum=0;
		
		q.add(root);
		while(!q.isEmpty()) {
			level++;
			int size = q.size();
			
			while(size > 0) {
				Tree p = q.poll();
				
				if(level % 2 == 0)
					evenSum = evenSum + p.data;
				else
					oddSum = oddSum + p.data;
				
				if(p.left != null)
					q.add(p.left);
				if(p.right != null)
					q.add(p.right);
				
				size--;
			}
		}
		return oddSum - evenSum;
	}
	
	
	public int recursive(Tree root) {
		if(root == null)
			return 0;
		
		return root.data - recursive(root.left) - recursive(root.right);
	}
}
