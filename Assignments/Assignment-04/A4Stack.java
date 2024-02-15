public class A4Stack<T> implements Stack<T> {
	
	private A4Node<T> head;
	// Do NOT add any other fields to this class.
	// You should be able to implement the Stack 
	// interface with just a head field.

	public A4Stack() {
		head = null;
		return; 
	}
	
	public void push(T value) {
		//put the new value at the front of the list
		A4Node<T> newNode = new A4Node<T>(value);
		newNode.next = head;
		head = newNode;
		return;
	}
	
	public T pop() {
		// remove and return the top item from the stack	
		if (head == null) {
			return null;
		}
		T result = head.getData();
		head = head.next;
		return result;
	}
	
	public void popAll() {
		// we can just set the head to null
		head = null;
		return; //the concept of intentionally losing the pointer to the list hurts my head. like all of my C alarm bells are going off. 
	}
	
	public boolean isEmpty() {
		//is the head null?
		return head == null; //bruh this is dead simple 
	}
	
	public T peek() {
		//get the top item on the stack
		if (head == null) {
			return null;
		}
		return head.getData(); //is this destructively getting the top item?

		
	}
	
	// Implemented for you for debugging purposes
	public String toString() {
		String result = "{";
		String separator = "";
		
		A4Node<T> cur = head;
		while (cur != null) {
			result += separator + cur.getData().toString();
			separator = ", ";
			cur = cur.next;
		}
	
		result += "}";
		return result;
	}
}