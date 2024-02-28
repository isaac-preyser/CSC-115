public class A5Exercises {

	/*
	 * Purpose: change all occurrences of x to y in the given list
	 * Parameters: List<T> theList - the list to search through
	 *			   T x - the value to change
	 *			   T y = the value to change all x's to
	 * Returns: void - nothing
	 */
	public static<T> void changeXToY(List<T> theList, T x, T y) {
		changeXToYHelper(theList, x, y, 0);
		return; //cant return void . . .
	}

	private static<T> void changeXToYHelper(List<T> theList, T x, T y, int position) {
		if (position == theList.size()) {
			return;
		} else {
			if (theList.get(position).equals(x)) {
				theList.change(position, y);
			}
			changeXToYHelper(theList, x, y, position + 1);
			return; //not sure if I should return here ...
		}
	}
	
	/*
	 * Purpose: count the total number of odd values in this list
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the total number of odd values found
	 */
	public static int countOdd(List<Integer> theList) {
		return countOddHelper(theList, 0);
	}

	private static int countOddHelper(List<Integer> theList, int position) {
		if (position == theList.size()) {
			return 0;
		} else {
			if (theList.get(position) % 2 != 0) {
				return 1 + countOddHelper(theList, position + 1); //why the frick did I do it this way
				//like bruh just use a counter argument
			} else {
				return countOddHelper(theList, position + 1);
			}
		}
	}
	

	/*
	 * Purpose: get the largest sequence of odd values found in a row
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the largest sequence of odd values found in a row
	 */
	public static int countMostOddInARow(List<Integer> theList) {
		return countMostOddInARowHelper(theList, 0, 0, 0);
	}

	private static int countMostOddInARowHelper(List<Integer> theList, int position, int count, int maxCount) {
		if (position == theList.size()) {
			return count > maxCount ? count : maxCount;
		} else {
			if (theList.get(position) % 2 != 0) {
				return countMostOddInARowHelper(theList, position + 1, count + 1, maxCount);
			} else {
				return countMostOddInARowHelper(theList, position + 1, 0, count > maxCount ? count : maxCount); //this code is terrible terrible terrible 
			}
		}
	}
	
	
	/*
	 * Purpose: count the elements found in between the first two x's
	 * Parameters: List<Integer> theList - the list of Integers
	 *             int x - the values to search for
	 * Returns: int - the number of values in the list found 
	 *                between the first 2 occurrences if x,
	 *                or -1 if there are not 2 x's in the list.
	 */
	public static int countBetweenX(List<Integer> theList, int x) {
		return countBetweenXHelper(theList, x, 0, 0, false);
	}

	//base case: if the our position is at the end of the list, stop. 
	//either return -1 if we haven't found 2 x's, or return the highest count if we have. 
	//recursive case: if we find an x, start counting, else, move on to the first iteration of x. 
	//if we encounter another x, stop counting and return the count.
	//foundFirstX is a boolean that will be true if we have found the first x, and will be false if we have not. 

	public static int countBetweenXHelper(List<Integer> theList, int x, int position, int count, boolean foundFirstX) {
		if (position == theList.size()){
			return -1;
		} else {
			if (theList.get(position) == x) {
				if (foundFirstX) {
					return count;
				} else {
					return countBetweenXHelper(theList, x, position + 1, 0, true);
				}
			} else {
				if (foundFirstX) {
					return countBetweenXHelper(theList, x, position + 1, count + 1, true);
				} else {
					return countBetweenXHelper(theList, x, position + 1, count, false);
				}
			}
		}
	}
	
	
}