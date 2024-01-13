public class Day2{

	public static void main(String[] args) throws Exception {
		// Call the methods you complete from the 
		// main method to determine if they work correctly.
		int[] a1 = {1, 2, 3, 4, 5};
		int[] a2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; 
		reverse(a2);
		int[] a3 = {5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
		int[] a4 = new int[5];
		a4 = reverseCopy(a3);
		

		//test averageValue
		double[] test1 = {1.0, 2.0, 3.0, 4.0, 5.0};
		double[] test2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};

		System.out.println("Average Value Test 1: " + averageValue(test1));
		System.out.println("Average Value Test 2: " + averageValue(test2));
		System.out.println();

		//test sumPositive
		double[] test3 = {1.0, 2.0, 3.0, 4.0, 5.0};
		double[] test4 = {1.0, 2.0, 3.0, 4.0, 5.0, -6.0};

		System.out.println("Sum Positive Test 1: " + sumPositive(test3));
		System.out.println("Sum Positive Test 2: " + sumPositive(test4));
		System.out.println();

		//test getMin
		double[] test5 = {1.0, 2.0, 3.0, 4.0, 5.0};
		double[] test6 = {1.0, 2.0, 3.0, 4.0, 5.0, -6.0};

		System.out.println("Get Min Test 1: " + getMin(test5));
		System.out.println("Get Min Test 2: " + getMin(test6));
		System.out.println();

		//test allOdd
		double[] test7 = {2.0, 3.0 , 4.0};
		double[] test8 = {1.0, 3.0, 5.0};

		System.out.println("AllOdd Test 1: " + allOdd(test7));
		System.out.println("AllOdd Test 2: " + allOdd(test8));
		System.out.println();
		return;
	}

	/*
	 * 1) Write a method named averageValue that takes an
	 *    array of integers and returns the average value
	 *    of all elements found in the array. Assume the array
	 *    contains at least one element.
	 */
	public static double averageValue(double[] inputArray){
		int count = 0;
		double sum = 0.0;
		for (int i = 0; i < inputArray.length; i++){
			sum += inputArray[i];
			count++;
		}
		return sum / count; 
	}
	/*
	 * 2) Write a method named sumPositive that takes an
	 *    array of integers and returns the sum of all 
	 *    the positive valued elements found in the array.
	 */
	 public static double sumPositive (double[] inputArray){
		double sum = 0.0; 
		for (int i = 0; i < inputArray.length; i++){
			if (inputArray[i] > 0){
				sum += inputArray[i];
			} else {
				continue;
			}
		}
		return sum;
	 }
	/*
	 * 3) Write a method named getMin that takes an array
	 *    of positive integers and returns the minimum 
	 *    value found in the array. If the array does 
	 *    not contain any elements, -1 is returned.
	 */
	public static double getMin(double[] inputArray){
		if (inputArray.length <= 0){
			return -1; //invalid length error (I kinda want to throw exceptions but in the spirit of CSC 115 I won't)
		} else {
			double min = inputArray[0];
			for (int i = 0; i < inputArray.length; i++){
				if(inputArray[i] <= min){
					//replace the minimum with the current value. 
					min = inputArray[i];
				}
			}
			return min;
		}
		
	}
	 
	/*
	 * 4) Write a method named allOdd that determines
	 *    if an array of integers contains only odd-numbered
	 *    elements (i.e. the array does not contain any
	 *    even-numbered elements).
	 */
	public static boolean allOdd(double[] inputArray) throws Exception{
		if (inputArray.length <= 0){
			throw new Exception("you can't give me an empty or negative length array!!! :( goodbye.");
			//return false; //ideally return some error code but cant return that with a boolean data type... 
		} else { 
			for (int i = 0; i < inputArray.length; i++){
				if (inputArray[i] % 2 == 0){
					//any number % 2 == 0 implies that it is even. if we get here, then we know that the current number is even, and thus, the given array is not "all odd".
					return false; 
				} else {
					continue;
				}
			}
			return true; //once we get here, we know that each value is odd. therefore, return true. 
		}

	}
	
	/*
	 * 5a) Write a method named reverse that takes an
	 *     array of integers and reverses all of the
	 *     elements found in the given array.
	 */
	public static int[] reverse(int[] inputArray) throws Exception{
		//weirdly, I miss pointers. 
		int buffer; 
		int start = 0;
		int end = inputArray.length - 1;
		while (start < end){
			buffer = inputArray[start];
			inputArray[start] = inputArray[end];
			inputArray[end] = buffer;
			end--;
			start++;
		} 

		
		return inputArray;
	}

	
	/*
	 * 5b) Write a method named reverse that takes an
	 *     array of integers and returns a new array that
	 *     contains the same elements as the given array, 
	 *     but in reverse order. 
	 */
	public static int[] reverseCopy (int[] inputArray){
		int[] arr = new int[inputArray.length];
		int length = inputArray.length - 1; 
		for (int i = 0; i < inputArray.length; i++){
			arr[length - i] = inputArray[i];
		}
		return arr; 
	}

}