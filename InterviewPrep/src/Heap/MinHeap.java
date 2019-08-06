package Heap;

import java.util.ArrayList;

public class MinHeap {
	
	ArrayList<Integer> heapArray = new ArrayList<Integer>();
	
	private int leftchild(int index) {
		return index*2+1;
	}
	
	private int rightchild(int index) {
		return index*2+2;
	}
	
	private int parent(int index) {
		if(index%2 == 0)
			return index/2 -1;
		else
			return index/2;
	}
	
	private boolean hasleftchild(int index) {
		if(leftchild(index) < heapArray.size()-1)
			return true;
		else
			return false;
	}
	
	private boolean hasrightchild(int index) {
		if(rightchild(index) < heapArray.size()-1)
			return true;
		else
			return false;
	}
	
	private boolean hasparent(int index) {
		if(parent(index) >= 0)
			return true;
		else
			return false;
	}
	
	public void insert(int element) {
		heapArray.add(element);
		heapifyUpwards();
	}
	
	public void delete(int element) {
		heapArray.remove(0);
		heapifyDownwards();
	}
	
	public int poll() {
		if(heapArray.size() < 0)
			throw new IllegalArgumentException();
		
		int temp = heapArray.get(0);
		heapArray.set(0, heapArray.get(heapArray.size()-1));
		heapArray.remove(heapArray.size()-1);
		
		heapifyDownwards();
		
		return temp;
	}
	
	public int peek() {
		if(heapArray.size() < 0)
			throw new IllegalArgumentException();
		
		return heapArray.get(0);
	}
	
	public void heapifyUpwards() {
		
		int index = heapArray.size()-1;
		
		while(hasparent(index) && heapArray.get(parent(index)) > heapArray.get(index)) {
			swap(parent(index), index);
			index = parent(index);
		}
	}
	
	public void heapifyDownwards() {
		int index = 0;
		
		while(hasleftchild(index)) {
			int smallchildindex = leftchild(index);
			
			if(hasrightchild(index) && heapArray.get(rightchild(index)) < heapArray.get(leftchild(index))) {
				smallchildindex = rightchild(index);
			}
			
			if(heapArray.get(index) > heapArray.get(smallchildindex)) {
				swap(index, smallchildindex);
			}
			else
			{
				break;
			}
			
			index = smallchildindex;
		}
	}
	
	private void swap(int parent, int index ) {
		int temp = heapArray.get(index);
		heapArray.set(index, heapArray.get(parent));
		heapArray.set(parent, temp);
	}
}
