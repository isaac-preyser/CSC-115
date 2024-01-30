public class NodeTester {



	static void printList(Node n){
		Node cur = n;
		while (cur != null){
			System.out.println(cur.getValue());
			cur = cur.next;
		}
	}

	public static void main (String[] args) {

		System.out.println("Part 1:");
		/* 1a. create a new blank (value 0) node n1 */

		Node n1 = new Node();


		/* 1b. create a new node n2 with a value of 9 */

		Node n2 = new Node(9);

		/* 1c. print the values in n1 and n2 */

		System.out.println("n1: " + n1.getValue());
		System.out.println("n2: " + n2.getValue());


		System.out.println("\nPart 2:");
		/* 2a. connect n1 to n2 such that n2 is before n1 */

		n2.setNext(n1);

		/* 2b. print the value in n1 and n2 without using the variable n1 */

		System.out.println("n2: " + n2.getValue());
		System.out.println("n1: " + n2.getNext().getValue());

		System.out.println("\nPart 3:");
		/* 3a. create a new node n3 with a value of 20 */

		Node n3 = new Node(20);

		/* 3b. assign our n1 variable so that it also references
		       the newly created node with data value 20 */

		n1 = n3;

		/* 3c. Can you still print the values in all 3 nodes?
			   Are the multiple ways to output n3's value? */
		
		//do this by printing n2.next.value, as it points to "old n1", then print n2.value, then n3.

		System.out.println("n1: " + n2.getNext().getValue());
		System.out.println("n2: " + n2.getValue());
		System.out.println("n3: " + n3.getValue());


		/* 3d. What happens if we n1.setValue(6); ? */

		//it will change the value of n3, as n1 points to n3. 
		n1.setValue(6);
		System.out.println("Printing n1.value: " + n1.getValue());
		System.out.println("Printing n3.value: " + n3.getValue());

		//printing "old n1", which is really n2.next, will print the old value of n1 (0).
		System.out.println("Printing n2.next.value: " + n2.getNext().getValue());

		System.out.println("\nPart 4:");
		/* 4a. connect n3 to the other two nodes such that n3 is
			   in between the other two */

		//our current order is: 
		// n2 -> old n1 -> null; n3 -> null;
		//we want to change it to:
		// n2 -> n3 -> old n1 -> null;

		//thus: 

		n3.setNext(n2.next); //this uses "old n1", which is n2.next, and sets it to n3.next.
		n2.setNext(n3);

		/* 4b. print all 3 values using only the n2 variable.
			   That is, you cannot use the variables n1 or n3 */
			 
		System.out.println("n2: " + n2.getValue());
		System.out.println("n2.next: " + n2.getNext().getValue());
		System.out.println("n2.next.next: " + n2.getNext().getNext().getValue());
		//THIS SYNTAX IS AWFUL, BUT IMPORTANT TO UNDERSTAND. 
		
		
		System.out.println("\nPart 5:");
		/* 5. Create a method that accepts a node as a parameter
			  and prints out the value of the given node as well 
			  as the values of all nodes that follow it. */
		printList(n2);
	}
}

