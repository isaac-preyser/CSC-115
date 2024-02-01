// Name: Isaac Preyser		
// Student number: v01022512

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
		

		//PLAN ::
		//1. if the list is empty, return
		//2. if the list has one element, set head and tail to null
		// else, set the tail to the current tail's prev. set the prev's next to null
		if(isEmpty()){
			return;
		}
		else if (length == 1){
			head = null;
			tail = null;
		}
		else{
			tail = tail.getPrev();
			tail.setNext(null);
		}

		this.length--;
		return;


	}
	
	
	
	//////////////////
	/* PART 2 BELOW */
	//////////////////
	
	public void removeMiddle() {
		// PLAN
		// 1. if the list is empty, return
		// 2. if number of elements is even, remove the two middle elements
		// 3. if number of elements is odd, remove the middle element
		// 4. decrement length by either 0, 1, or 2, depending on the case. 

		if(this.isEmpty()){
			return;
		}

		if(this.length == 1){
			head = null;
			tail = null;
			return;
		}

		if(this.length == 2){
			//technically, both are "in the middle". 
			//remove both
			head = null;
			tail = null; 
			return;
		}

		A3Node temp = head;

		for (int i = 0; i < length/2; i++){
			temp = temp.getNext();
		}

		Boolean isEven = (length % 2 == 0);

		if (isEven){
			//even length. we must remove the current node, and the previous one too. 
			//temp is the 2nd item to remove; also need to remove temp-1. 
			A3Node remove2 = temp.getPrev(); 
			

			remove2.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(remove2.getPrev());
			
			remove2 = null;

		} else if (!isEven){
			//odd length. remove only the current node, and perform the following switch: 
			temp.getPrev().setNext(temp.getNext()); //(set the previous item to be pointing at the "next" item)
			temp.getNext().setPrev(temp.getPrev()); // set the next item to be pointing at the "prev" item
		}

		temp = null; 
		System.gc(); //free up now nulled memory


		return;
		
	}
	
	public void interleave(A3LinkedList other) {
		// TODO: implement this
		//essentially, for every second item in the list, swap the items in listA and listB. 
		
		//every odd node should point to the other list's n+1 node.
		//in the other list, every even node should point to the other lists n+1 node.
		//essentially, given two lists: 
		//listA: a1, a2, a3, a4, a5
		//listB: b1, b2, b3, b4, b5
		//result: listA: a1, b2, a3, b4, a5
		//result: listB: b1, a2, b3, a4, b5

		if (other.isEmpty() || this.isEmpty()){
			return;
		}

		A3Node tempA = this.head;
		A3Node tempB = other.head;
		A3Node tempC = null;

		while (tempA != null && tempB != null){
			tempC = tempA.getNext();
			tempA.setNext(tempB.getNext());
			tempB.setNext(tempC);

			tempA = tempA.getNext();
			tempB = tempB.getNext();

		}

		

		return;
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
	