public class RecursionExercises {
    	
	/*
	 * Purpose: sum all values from n down to 1
	 * Parameters: int - n
	 * Returns: int - the sum
	 * Preconditions: n >= 0
	 */
	public static int sum(int n) {
		// TODO: implement this method
		return 0; // so it compiles
	}
	
	/*
	 * Purpose: sum all values from n^2 down to 1^2
	 * Parameters: int - n
	 * Returns: int - the sum of squares
	 * Preconditions: n > 0
	 */
	public static int sumSquares(int n) {
		// TODO: implement this method
		return 0; // so it compiles
	}
	
	/*
	 * Purpose: sum all odd values from n down to 1
	 * Parameters: int - n
	 * Returns: int - the sum of odd values
	 * Preconditions: n > 0
	 */
	public static int sumOdd(int n) {
		// TODO: implement this method
		return 0; // so it compiles
	}
	
	/*
	 * Purpose: get the sum of all values in the array
	 * Parameters: int[] arr - the array
	 * Returns: int - the sum
	 */
	public static int sumArray(int[] arr) {
		// TODO: implement this method
		return 0; // so it compiles
	}
	
	/*
	 * Purpose: count the number of negative values found 
	 *          in the array
	 * Parameters: int[] arr - the array
	 * Returns: int - count of negatives values found
	 */	
	public static int countNegative(int[] arr) {
		// TODO: implement this method
		return 0; // so it compiles
	}
	
	/*
	 * Purpose: count the number of values in the array 
	 *          with a value equal to n
	 * Parameters: (int[]) arr - the array
				   (int) n - value to search for
	 * Returns: int - count of elements equal to n
	 */	
	public static int countEqualTo(int[] arr, int n) {
		// TODO: implement this method
		return 0; // so it compiles
	}
	
	/*
	 * Purpose: determine if the values in array are all above n
	 * Parameters: int[] arr - the array
	 *			   int n - threshold elements must be greater than
	 * Returns: boolean - true if all values are greater than n
	 */	
	public static boolean allAbove(int[] arr, int n) {
		// TODO: implement this method
		return false; // so it compiles
	}	


///////////////////////////////////
//		DAY 2 EXERCISES          //
///////////////////////////////////


	/*
	 * Purpose: determine if three elements with value x are found
	 *          in the given array in a row
	 * Parameters: int[] arr - the array, 
	 *             int x - the value to search for three in a row
	 * Returns: boolean - true if there are 3 x's in a row
	 */	
	public static boolean threeXInARow(int[] arr, int x) {
		if (arr.length < 3) {
			return false; //if the array is less than 3 elements, return false
		} else {
			return threeXInARowRec(arr, 0, x, 0); //otherwise, call the helper method
		}
		
		
	}
	
	/*
	 * Purpose: helper method for threeXInARow
	 * Parameters: int[] arr - the array, 
	 *             int x - the value to search for three in a row
	 *             int i - the current index in the array
	 * 		       int count - the current count of x's in a row
	 * Returns: boolean - true if there are 3 x's in a row
	 */

	private static boolean threeXInARowRec(int[] arr, int i, int x, int count) {
		if(count == 3){
			return true; //if the count is 3, return true
		} else if(i == arr.length){
			return false; //if the end of the array is reached, return false
		} else if(arr[i] == x){
			return threeXInARowRec(arr, i+1, x, count+1); //if the current element is x, increment the count, and continue to the next element

		} else {
			return threeXInARowRec(arr, i+1, x, 0); //if the current element is not x, reset the count and continue to the next element
		}
	}
	

	/*
	 * Purpose: determine if three elements with the same value in a row
	 * Parameters: int[] arr - the array
	 * Returns: boolean - true if there are 3 of the same value in a row
	 */	
	public static boolean threeInARow(int[] arr) {
		// TODO: implement this method
		if (arr.length < 3) {
			return false; //if the array is less than 3 elements, return false
		} else {
			return threeInARowRec(arr, 0, arr[0], 0); //otherwise, call the helper method
		}
	}
	
	//helper method for threeInARow. assuming the array has at least 3 elements, 
	//or else the base case will never be satisfied and we will get an infinite loop
	//int[] arr - the array,
	//int i - the current index in the array
	//int value - the value to search for three in a row
	//int count - the current count of the value in a row
	//Returns: boolean - true if there are 3 of the same value in a row
	private static boolean threeInARowRec(int[] arr, int i, int value, int count) {
		if(count == 3){
			return true; //if the count is 3, return true
		} else if(i == arr.length){
			return false; //if the end of the array is reached, return false
		} else if(arr[i] == value){
			return threeInARowRec(arr, i+1, value, count+1); //if the current element is the same as the previous, increment the count, and continue to the next element

		} else {
			return threeInARowRec(arr, i+1, arr[i], 1); //if the current element is not the same as the previous, reset the count and continue to the next element
		}
	}
	
	/*
	 * Purpose: determine if there are n elements with the same value in a row
	 * Parameters: int[] arr - the array
	 *             int n - the number in a row to find
	 * Returns: boolean - true if there are n of the same value in a row
	 */	
	public static boolean nInARow(int[] arr, int n) {
		// TODO: implement this method
		return false;
	}	
	
}
