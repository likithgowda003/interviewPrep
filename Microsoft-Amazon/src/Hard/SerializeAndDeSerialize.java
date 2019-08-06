package Hard;

import java.util.LinkedList;

public class SerializeAndDeSerialize {
	
	public String serialize(Tree root) {
		
		if(root == null)
			return null;
		
		StringBuilder sb = new StringBuilder();
		LinkedList<Tree> queue = new LinkedList();
		
		queue.add(root);		
		while(!queue.isEmpty()) {
			Tree t = queue.poll();
			if(t!=null) { 
				sb.append(String.valueOf(t.data) + ",");
				queue.add(t.left);
				queue.add(t.right);
			}
			else
			{
				sb.append("#,");
			}
		}	
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();		
	}
	
	

	public Tree deserialization(String str) {
		
		if(str == null)
			return null;
		
		String[] arr = str.split(",");
		
		Tree root = new Tree(Integer.parseInt(arr[0]));
		LinkedList<Tree> queue = new LinkedList();
		
		queue.add(root);
		
		int i=1;
		while(!queue.isEmpty()) {
			Tree t = queue.poll();
			
			if(t == null)
				continue;
			
			if(!arr[i].equals("#")) {
				t.left = new Tree(Integer.parseInt(arr[i]));
				queue.add(t.left);
			}
			else
			{
				t.left = null;
				queue.add(null);
			}
			i++;
			
			if(!arr[i].equals("#")) {
				t.right = new Tree(Integer.parseInt(arr[i]));
				queue.add(t.right);
			}
			else
			{
				t.right = null;
				queue.add(null);
			}
			i++;
		}
		return root;
	}	
}
