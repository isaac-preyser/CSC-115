

public class QueueRefBased implements Queue {

	private QueueNode front;
	private QueueNode back;
	// no numElements for this implementation

	public QueueRefBased() {
		front = null;
		back = null;
	}

	public int size() {
		int count = 0;	
		QueueNode current = front;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;			
	}

	public boolean isEmpty() {
		if (front == null) {
			return true;
		} 
		
		return false;
	}

	public void enqueue (int value) {
		QueueNode newNode = new QueueNode(value);
		//back points to the new node. 
		//new node points to null 
		if (back == null) {
			back = newNode;
			front = newNode;
		} else {
			back.next = newNode;
			back = newNode;
		}

	}

	public int dequeue() {
		//grab the first value in the queue. 
		int value = front.data;

		//move the front to the next node in the queue
		front = front.next;

		//if the queue is now empty, set the back to null
		if (front == null) {
			back = null;
		}
		return value;
	}

	public int peek()  {
		if (front == null) {
			System.out.println("Error: Queue is empty");
			return -1;
		}
		
		return front.data;
	}

	public void makeEmpty() {
		front = null;
		back = null;

	}
}
