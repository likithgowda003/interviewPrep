package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://www.programcreek.com/2012/12/leetcode-clone-graph-java/

public class CloneGraph {
	
	class Node {
		int val;
		ArrayList<Node> neighbours = new ArrayList<Node>(); 
		
		public Node(int val, ArrayList<Node> neighbours) {
			this.val = val;
			this.neighbours = neighbours;
		}
	}
	
	
	// hash map -->  key:orgNode    value:clonedNode
	public Node clone(Node n) {
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Queue<Node> q = new LinkedList<Node>();
		// create clone of the node
		map.put(n, new Node(n.val, new ArrayList<>()));
		q.add(n);
		
		while(!q.isEmpty()) {
			Node top = q.poll();
			
			for(Node neighbour : top.neighbours) {
				// if map does not contain the cloned node (remember, map contains key as orgNode and val as clonedNode only)
				if(!map.containsKey(neighbour)) {
					map.put(neighbour, new Node(neighbour.val, new ArrayList<Node>()));
					q.add(neighbour);
				}
				// get the clones node and add the current neighbour to the cloned neighbour list
				map.get(top).neighbours.add(map.get(neighbour));
			}
		}
		return map.get(n);
	}
}
