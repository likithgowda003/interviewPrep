package Trees;

import java.util.TreeMap;
import java.util.Vector;

public class VerticalOrderBinaryaTree {
	
	static void getVerticalOrder(Tree root, int hd,
            TreeMap<Integer,Vector<Integer>> m) {
		
		if(root == null)
			return;
		
		Vector<Integer> k = m.get(hd);
		
		if(k ==  null) {
			k = new Vector<>();
			k.add(root.data);
		}
		else {
			k.add(root.data);
		}
		
		m.put(hd, k);
		
		getVerticalOrder(root.left, hd-1, m);
		getVerticalOrder(root.right, hd+1, m);
	}
}
