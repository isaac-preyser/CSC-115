public class IntegerArrayList implements IntegerList {

	private static final int INITIAL_SIZE = 10;

	private int[] data; // the array storing the elements
	private int numElements; // the current number of elements in the integer list

	private void resize(int num_spaces){
		//create a new array with num_spaces extra spaces
		int[] temp = new int[data.length + num_spaces];
		//copy all elements from data to temp
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		//set data to temp
		data = temp;
	}

	public IntegerArrayList() {
		data = new int[INITIAL_SIZE];
		numElements = 0;
	}

	public void addFront(int val) {
		//BATTLE PLAN: 
		//1. shift all elements to the right
		//2. insert val at position 0
		//3. increment numElements
		//Case: if we don't have enough room, resize
		if (numElements == data.length) {
			resize(1);
		}
		//now we assume that we have room to add an element. 


		//shift all elements to the right
		for (int i = numElements; i > 0; i--) {
			
			//start at the end of the list, and move each element to the right. 
			data[i] = data[i - 1]; //set the current index to the value of the previouse index. 	
		}
		//insert val at position 0
		data[0] = val;
		//increment numElements
		numElements++;
	}
	
	public void addBack(int val) {
		//we want to place this value at the end of the list. 
		//Case: if we don't have enough room, resize
		if (numElements == data.length) {
			resize(1);
		}
		//now we assume that we have room to add an element.


		//add val to the end of the list
		data[numElements] = val; //numElements is the index of the last element
		//increment numElements
		numElements++;

	}

	public void insertAt(int position, int val) {
		//shift all elemennts after position to the right
		//insert val at position. 

		//Case: if we don't have enough room, resize
		if (numElements == data.length) {
			resize(1);	
		}
		//now we assume that we have room to add an element.


		//shift all elements after position to the right
		for (int i = numElements; i > position; i--) {
			data[i] = data[i - 1];
		}
		//insert val at position
		data[position] = val;
		//increment numElements
		numElements++;

	}

	public int size() {
		return numElements;
	}
	
	public int get(int position) {
		return data[position];
	}

	/* toString
	 * Purpose: create a string representation of list
	 * Parameters: nothing
	 * Returns: (String) the string representation of the list
	 */
	public String toString() {
		String s = "List contents:";

		for(int i=0; i<numElements; i++) {
			s += " " + data[i];
		}

		return s;
	}

}
