// Name:
// Student number: v00

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		// TODO: implement this
		//PLAN :: 
		//1. create a new node with the data s
		//2. if the list is empty, set head and tail to the new node
		//3. if the list is not empty, set the new node's next to the current head
		//4. set the current head's prev to the new node.
		//5. set the head to the new node.
		//6. increment length.

		A3Node newNode = new A3Node(s);
		if (isEmpty()){
			head = newNode;
			tail = newNode;
		}
		else{
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		}
		length++;
		return;

	}

	public void addBack(String s) {
		// TODO: implement this
		//PLAN ::
		//1. create a new node with the data s
		//2. if the list is empty, set head and tail to the new node
		//3. if the list is not empty, set the new node's prev to the current tail
		//4. set the current tail's next to the new node.
		//5. set the tail to the new node.
		//6. increment length.

		A3Node newNode = new A3Node(s);
		if (isEmpty()){
			head = newNode;
			tail = newNode;
		}
		else{
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
		length++;
		return;
		
		
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		// TODO: implement this
		//PLAN ::
		//1. if the list is empty, return
		//2. if the list has one element, set head and tail to null
		//3. if the list has more than one element, set the head to the current head's next
		//4. set the new head's prev to null
		//5. decrement length

		if (isEmpty()){
			return;
		}
		else if (length == 1){
			head = null;
			tail = null;
		}
		else{
			head = head.getNext();
			head.setPrev(null);
		}
		length--;
		return;

	}
	
	public void removeBack() {
		// TODO: implement this
	}
	
	
	
	//////////////////
	/* PART 2 BELOW */
	//////////////////
	
	public void removeMiddle() {
		// TODO: implement this
	}
	
	
	public void interleave(A3LinkedList other) {
		// TODO: implement this
	}
	
	
	
	////////////////////////////////////////
	/* METHODS BELOW TO HELP WITH TESTING */
	////////////////////////////////////////
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 *
	 * USED TO HELP YOU WITH DEBUGGING
	 * DO NOT CHANGE THIS METHOD
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	