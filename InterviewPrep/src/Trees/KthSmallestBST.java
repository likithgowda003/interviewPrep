package Trees;

public class KthSmallestBST {

	public int kthsmallest(Tree root, int k) {
		
		int count = 0, ksmall = 0;
		Tree cur = root;
		
		while(cur!=null) {
			if(cur.left == null) {
				
				// instead of printing, increment count and set count
				count++;
				if(count == k)
					ksmall = cur.data;
				
				cur = cur.right;
			}
			else {
				Tree pre = cur.left;
				while(pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				
				if(pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				}
				else {
					pre.right = null;
					
					// instead of printing, increment count and set count
					count++;
					if(count == k)
						ksmall = cur.data;
					
					cur = cur.right;
				}
			}
		}
		return ksmall;
	}
}
