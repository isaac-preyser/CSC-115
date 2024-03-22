/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapPriorityQueue implements PriorityQueue {
	//this is a minimum heap. The smallest element is at the root.
	protected final static int DEFAULT_SIZE = 10000;
	
	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		storage = new Comparable[DEFAULT_SIZE]; //using a 0-based implementation. 
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		storage = new Comparable[size]; //using a 0-based implementation.
	}

	public void insert (Comparable element) throws HeapFullException {
		//using 0-based implementation. 

		//check that the heap is not full
		if (isFull()) {
			throw new HeapFullException();
		}

		//insert the element at the end of the heap
		storage[currentSize] = element;
		//bubble up the element to its correct position
		bubbleUp(currentSize);
		//increment the size of the heap
		currentSize++;		
    }
	
	public void bubbleUp(int index) {
		//using 0-based implementation.
		//if the element is at the root, return
		if (index == 0) {
			return;
		}
		//find the parent of the element
		int parent = (index - 1) / 2;
		//if the element is less than its parent, swap them
		if (storage[index].compareTo(storage[parent]) < 0) {
			Comparable temp = storage[index];
			storage[index] = storage[parent];
			storage[parent] = temp;
			//bubble up the parent
			bubbleUp(parent);
		}
		//done!
	}
			
	public Comparable removeMin() throws HeapEmptyException {
		//if the heap is empty throw an exception
		if (isEmpty()) {
			throw new HeapEmptyException();
		}
		//store the minimum element
		Comparable min = storage[0];
		//move the last element to the root
		storage[0] = storage[currentSize - 1];
		//decrement the size of the heap
		currentSize--;
		//bubble down the root to its correct position
		bubbleDown(0);
		//return the minimum element
		return min;
		
	}
	
	private void bubbleDown(int index) {
		//if the element is a leaf, return
		if (index >= currentSize / 2) {
			return;
		}
		//else, find the smallest child
		int left_child_idx = 2 * index + 1;
		int right_child_idx = 2 * index + 2;

		//if the right child is out of bounds, assume the left child is the smallest
		int min_child_idx = right_child_idx >= currentSize || storage[left_child_idx].compareTo(storage[right_child_idx]) < 0 ? left_child_idx : right_child_idx; 
		//if the current element is greater than its smallest child, swap them
		if (storage[index].compareTo(storage[min_child_idx]) > 0) {
			Comparable temp = storage[index];
			storage[index] = storage[min_child_idx];
			storage[min_child_idx] = temp;
			//bubble down the smallest child
			bubbleDown(min_child_idx);
		}
		//done!
		
	}

	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public boolean isFull() {
	
		return currentSize == storage.length;
	}
	
	public int size () {
		
		return currentSize;
	}

	public String toString() {
		String s = "";
		String sep = "";
		// This implementation of toString assumes you 
		// are using a 1-based approach. Update the initial
		// and final value for i if using a 0-based
		for(int i=0; i<currentSize; i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}
}
