/*
 * represents a line-up to get into the venue of a music concert
 */

public class ConcertLine {

	private PriorityQueue attendees;

	// using array-based implementation of a priority queue, as established in PriorityQueue.java

	//this will be a min-heap queue, sorted as follows:
	// 1. VIP ticket holders (tie-break: time entered line)
	// 2. Premier ticket holders (tie-break: time entered line)
	// 3. General ticket holders (tie-break: time entered line)

	// if two attendees have the same ticket type and entered the line at the same time,
	// they are considered equal priority and can be served in any order

	/* 
 	 * constructor that initializes attendees to a default-sized priority queue
	 */
	public ConcertLine() {
		//instantiating a priority queue with default size
		attendees = new HeapPriorityQueue();
	}

	/* 
	 * constructor that initializes attendees to a priority queue of given size
	 */
	public ConcertLine(int size) {
		//instantiating a priority queue with given size
		attendees = new HeapPriorityQueue(size);
	}


	/* Purpose: add given Attendee to attendees line or prints
	 *          a notification message if attendees is full
	 * Parameters: Attendee a - the attendee who just arrived at
	 *             the concert and wants to enter the venue
	 * Returns: void - nothing
	 */
	public void addAttendee(Attendee a) {
		try {
			attendees.insert(a);
		} catch (HeapFullException e) {
			System.out.println("Sorry, the line is full. Please come back later.");
		}
		
	}


	/* Purpose: gets the number of attendees waiting to get in
	 * Parameters: none
	 * Returns: int - number of attendees waiting to get in
	 */
	public int numAttendeesWaiting() {
		return attendees.size(); 
	}


	/* Purpose: removes and returns the next attendee from attendees
	 * Parameters: none
	 * Returns: Attendee - the next attendee, null if there are no more
	 *                     attendees waiting to get into the venue.
	 */
	public Attendee nextAttendee() {
		try {
			return (Attendee) attendees.removeMin(); //fix using a cast lol
		} catch (HeapEmptyException e) {
			return null;
		}
	}
}

