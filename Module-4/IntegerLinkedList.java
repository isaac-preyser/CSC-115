public class IntegerLinkedList implements IntegerList {
    
	private Node head;
	private int numElements;

	public IntegerLinkedList() {
		head = null;
		numElements = 0;
	}

	public void addFront (int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		numElements++;
	}

	public void addBack (int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		}
		else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		numElements++;
	}

	public int size (){
		return this.numElements;
	}

	public int get (int position) {
		Node current = head;
		for (int i = 0; i < position; i++) {
			current = current.next;
		}
		return current.getValue();
	}
	
	public void insertAt (int position, int val) {
		
	}

	/* Purpose: create a string representation of list 
	 * Parameters: none
	 * Returns: String - the string representation
	 */
	public String toString() {
		String s = "List contents: ";
		return s;
	}    
}



