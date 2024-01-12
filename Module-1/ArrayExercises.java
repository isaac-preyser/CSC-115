public class ArrayExercises {

	public static void main (String[] args) {

		/* Q1. Complete the arrayReview Questions */
		//arrayReview ();

		/* Q2. Complete the implementation of sumPositive, which 
		   gets the sum of all positive values found in an array. */
		testSumPositive();
		
		/* Q3. Complete the implementation of ArraysEqual, which 
		   determines if two arrays have the same elements in the same order. */
		testArraysEqual();

		// Q4. Write and test a method that takes an array of integers,
		// and doubles all the values in the array
		testDoubleAll();

		// Q5. Write and test a method that given an array of integers,
		// determines if all the values in the array are odd
		testAllOdd();

	}

	public static void arrayReview () {
			
		// // Q1a. What is the output of the following:
		int[] array1 = null;
		// System.out.println("array1: " + array1);
		// System.out.println("array1[5]: " + array1[5]);
		// //null pointer exception - array1 is null, so it doesn't have a value at index 5.

		// Q1b. What is the output of the following:
		// array1[1] = 5;
		// System.out.println("array1[1]: " + array1[1]); //null pointer exception, because array1 is null. there is no pointer to array1[1].
		


		// Q1c. What is the output of the following:
		int[] array2 = {4, 5, 6};
		System.out.println("array2: " + array2);
		// System.out.println("array2[1]: " + array2[1]); //4
		//the output will be the memory address of the array, and then the value at index 1 (which is 4). 


		// Q1d. What is the output of the following:
		// double[] array3 = new double[2];
		// System.out.println("array3: " + array3);
		// System.out.println("array3[0]: " + array3[0]);
		// System.out.println("array3[10]: " + array3[10]);
		//first output: memory location. second output: 0.0. third output: index out of bounds exception. since the array is instantiated with type double, the default value is 0.0. 
		

		array1 = array2; //array 1 now points to the same array as array 2.
		array1[1] = 9;	//array 1 and array 2 now both have the value 9 at index 1. 
		System.out.println("array1: " + array1); //memory location
		System.out.println("array2[0]: " + array2[0]); //4
		System.out.println("array2[1]: " + array2[1]); //9
		

	}     
	
	public static void testSumPositive() {
		System.out.println("Testing sumPositive");
		int result = 0;
		int expected = 0;
		
		int[] arr0 = new int[0];
		int[] arr1 = {7};
		int[] arr2 = {-7};
		int[] arr3 = {8, -1, -4, 2};
		int[] arr4 = {5, -9, 4, -2};
		int[] arr5 = {-1, 2, 3};
		
		result = sumPositive(arr0);
		expected = 0;
		System.out.println("sumPositive empty array");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		result = sumPositive(arr1);
		expected = 7;
		System.out.println("sumPositive [7]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
	
		result = sumPositive(arr2);
		expected = 0;
		System.out.println("sumPositive [-7]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		result = sumPositive(arr3);
		expected = 10;
		System.out.println("sumPositive [8, -1, -4, 2]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		result = sumPositive(arr4);
		expected = 9;
		System.out.println("sumPositive [5, -9, 4, -2]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		result = sumPositive(arr5);
		expected = 5;
		System.out.println("sumPositive [-1, 2, 3]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
	}
	
	/*
	 * Purpose: Gets the sum of all positive values in the array
	 * Parameters: int[] arr
	 * Returns: int - the sum of all positive values
	 */
	public static int sumPositive(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				sum += arr[i]; //if the value at index i is positive, add it to the sum.
			}
		}
		return sum; // so it compiles
	}

	public static void testArraysEqual() {
		System.out.println("\nTesting arraysEqual");
		int[] asc1 = {1, 2, 3, 4};
		int[] asc2 = {1, 2, 3, 4, 5};
		int[] des1 = {4, 3, 2, 1};
		int[] des2 = {4, 3, 2, 1};
		boolean same = arraysEqual(asc1, asc2);
		// What should the result be?
		//the result shoud be false. 
		System.out.println("arraysEqual {1,2,3,4} and {1,2,3,4,5}: " + same + ": should be (false)");

		same = arraysEqual(asc1, des1);
		// What should the result be?
		//should be false. 
		System.out.println("arraysEqual {1,2,3,4} and {4,3,2,1}: " + same + ": should be (false)");
		
		same = arraysEqual(des1, des2);
		// What should the result be?
		//should be true.
		System.out.println("arraysEqual {4,3,2,1} and {4,3,2,1}: " + same + ": should be (true)");
	}

	/*
	 * Purpose: Determines whether two arrays are equal
	 * Parameters: int[] a, int[] b - the two arrays
	 * Returns: boolean - true if arrays are the size length with 
	 *                    the same values at each position
	 */
	public static boolean arraysEqual(int[] a, int[] b) {
		if (a.length != b.length) { //if the arrays are not the same length, return false.
			return false;
		}
		//now we know the arrays are the same length. 
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) { //if the values at index i are not equal, return false.
				return false;
			}
		}
		return true; // if we make through the above tests the arrays are equal. 
	}

	
	public static void testDoubleAll() {
		System.out.println("\nTesting doubleAll");
		int[] a1 = {7, 1, 3, 4};
		int[] a1x2 = {14, 2, 6, 8};
		
		doubleAll(a1);
		// How do we test if the method works?
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a1x2[i]) {
				System.out.println("Error: doubleAll failed. Expected: " + a1x2[i] + " Actual: " + a1[i] + " at index " + i + ".");
				return;
			}
		}
		System.out.println("doubleAll passed.");
		return;
	}

	/*
	 * Purpose: Doubles the values of all elements in given array
	 * Parameters: int[] arr - the array to modify
	 * Returns: void - nothing
	 */
	public static void doubleAll(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * 2; //double the value at index i.
		}
		return; //all done. 
	}
		
	public static void testAllOdd() {
		System.out.println("\nTesting allOdd");
		boolean result = false;
		boolean expected = false;
		
		int[] a1 = {2};
		result = allOdd(a1);
		System.out.println("allOdd {2} should be "+expected+", result: "+result);
		
		int[] a2 = {3};
		expected = true;
		result = allOdd(a2);
		System.out.println("allOdd {2} should be "+expected+", result: "+result);
		
		int[] a3 = {3, 5, 6};
		result = allOdd(a3);
		expected = false;
		System.out.println("allOdd {3, 5, 6}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);

		int[] a4 = {7, 9, 15, 2, 5};
		result = allOdd(a4);
		expected = false;
		System.out.println("allOdd {7,9,15,2,5}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		int[] a5 = {7, 9, 15, 5};
		result = allOdd(a5);
		expected = true;
		System.out.println("allOdd {7,9,15,5}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		int[] a6 = {6, 7, 9, 15, 2, 5};
		result = allOdd(a6);
		expected = false;
		System.out.println("allOdd {6,7,9,15,2,5}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
	}
	
	/*
	 * Purpose: Determine if the array contains only odd values
	 * Parameters: int[] arr 
	 * Returns: boolean - true if the array contains only odd values,
	 *                    false if at least one even value is found
	 */
	public static boolean allOdd(int[] arr) {
		boolean noEvens = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) { //if the value at index i is even, set noEvens to false.
				noEvens = false;
			}
		}
		return noEvens;
	} 


}
