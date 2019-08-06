package Trees;

// keep going until u find the node
// return true once node found
// print all nodes which receives a true from either of its children
public class AncestorsOfNode {

	public boolean printAncestors(Tree root, int data){
		if(root == null)
			return false;
		
		if(root.data == data)
			return true;
		
		if(printAncestors(root.left, data) || printAncestors(root.right, data)) {
			System.out.println(root.data);
			return true;
		}
		return false;
	}
}
