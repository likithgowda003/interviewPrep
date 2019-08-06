package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesBetweenLevels {
	
	public void print(Tree root, int start, int end) {
		Queue<Tree> q = new LinkedList<Tree>();
		int level=0;
		
		q.add(root);
		
		while(!q.isEmpty()) {
			level++;
			int size = q.size();
			
			while(size != 0) {
				Tree p = q.poll();
				
				if(p.data >= start && p.data<=end)
					System.out.println(p.data);
				
				if(p.left != null)
					q.add(p.left);
				if(p.right != null)
					q.add(p.right);
				
				size--;
			}
			
			if(level>= start && level<=end)
				System.out.println(" ");
		}
	}
}
