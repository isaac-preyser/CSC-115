public class StudentLinkedList implements StudentList {

	StudentNode head;
	int count;

	public StudentLinkedList() {
		head = null;
		count = 0;
	}

	public void add(Student s) {
		//plan:: create a new node. 
		//if the list is empty, set the new node as the head
		//else, put the new node at the end of the list. 
		StudentNode newNode = new StudentNode(s);
		if(head == null) {
			head = newNode;
		}else {
			StudentNode tmp = head;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.setNext(newNode);
		}
		//increment the count
		count++;
		return;


	}

	public int size() {

		//return the count
		return count;

	}

	public void removeFront() {

		//if the list is empty, do nothing
		//else, remove the first node by setting the head to the next node
		if(head != null) {
			head = head.next;
			count--;
		}
		//decrement the count
		return; 
	}

	public boolean contains(Student s) {

		//if the list is empty, return false
		//else, iterate through the list and return true if the student is found
		StudentNode tmp = head;

		
		while(tmp != null) {
			if(tmp.getData().getSID() == s.getSID()) {
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this list separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		// DO NOT CHANGE THIS METHOD - it is correct
		// Changing it will result in your code getting
		// a score of 0 from the autograder for this lab
		
		String s = "";
		StudentNode tmp = head;

		while(tmp != null) {
			s  += tmp.getData() + "\n";
			tmp = tmp.next;
		}

		return s;
	}
}
