public class RecursionTester {

	private static int testPassCount = 0;
	private static int testCount = 0;

	public static void main(String[] args) {
		
		/* implement and test each of the methods
		   in RecursionExercises.java, one at a time */
		
		/* recursive methods that operate on an integer */
		// testSum();
		// testSumSquares();
		// testSumOdd();
		
		/* recursive methods that operate on an array */
		testSumArray();
		// testCountNegative();
		// testCountEqualTo();
		// testAllAbove();
		
		/* recursive methods that requires an accumulator */
		// testThreeXInARow();
		// testThreeInARow();
		// testNInARow();
		
		System.out.println("\nPASSED " + testPassCount + "/" + testCount + " tests");
	}

	public static void testSum() {
		int result = 0;
		result = RecursionExercises.sum(1);
		displayResults(result==1, "testSum1");
		
		result = RecursionExercises.sum(5); 
		// should be 5+4+3+2+1=15
		displayResults(result==15, "testSum2");
		
		result = RecursionExercises.sum(7); 
		// should be 7+6+5+4+3+2+1=28
		displayResults(result==28, "testSum3");
	}

	public static void testSumSquares() {
		int result = 0;
		result = RecursionExercises.sumSquares(1);
		displayResults(result==1, "testSumSquares1");
		
		result = RecursionExercises.sumSquares(3); 
		// should be 1+4+9=13
		displayResults(result==14, "testSumSquares2");
		
		result = RecursionExercises.sumSquares(5); 
		// should be 1+4+9+16+25=55
		displayResults(result==55, "testSumSquares3");
	}

	public static void testSumOdd() {
		int result = 0;
		result = RecursionExercises.sumOdd(1);
		displayResults(result==1, "testSumOdd1");
		
		result = RecursionExercises.sumOdd(5); 
		// should be 1+3+5=9
		displayResults(result==9, "testSumOdd2");
		
		result = RecursionExercises.sumOdd(10); 
		// should be 1+3+5+7+9=25
		displayResults(result==25, "testSumOdd3");		
	}

	public static void testSumArray() {
		int result = 0;
		
		int[] arr0 = {};
		result = RecursionExercises.sumArray(arr0);
		displayResults(result==0, "testSumArray0");
		
		int[] arr1 = {3};
		result = RecursionExercises.sumArray(arr1);
		displayResults(result==3, "testSumArray1");
		
		int[] arr2 = {8, 1, 3, 4};
		result = RecursionExercises.sumArray(arr2);
		// should be 8+1+3+4=16
		displayResults(result==16, "testSumArray2");
		
		int[] arr3 = {4, 1, 3, 2, 5, 6, 2};
		result = RecursionExercises.sumArray(arr3);
		// should be 4+1+3+2+5+6+2=23
		displayResults(result==23, "testSumArray3");	
	}

	public static void testCountNegative() {
		int result = 0;
		
		int[] arr0 = {};
		result = RecursionExercises.countNegative(arr0);
		displayResults(result==0, "testCountNegative0");
		
		int[] arr1 = {3};
		result = RecursionExercises.countNegative(arr1);
		displayResults(result==0, "testCountNegative1");
		
		int[] arr2 = {-3};
		result = RecursionExercises.countNegative(arr2);
		displayResults(result==1, "testCountNegative2");
		
		int[] arr3 = {-8, 1, -3, -4};
		result = RecursionExercises.countNegative(arr3);
		displayResults(result==3, "testCountNegative");	
		
		int[] arr4 = {-4, -1, 3, -2, -5, -6, 2};
		result = RecursionExercises.countNegative(arr4);
		displayResults(result==5, "testCountNegative3");	
	}

	public static void testCountEqualTo() {
		int result = 0;
		
		int[] arr0 = {};
		result = RecursionExercises.countEqualTo(arr0, 3);
		displayResults(result==0, "testCountEqualTo0");
		
		int[] arr1 = {5};
		result = RecursionExercises.countEqualTo(arr1, 4);
		displayResults(result==0, "testCountEqualTo1");
		result = RecursionExercises.countEqualTo(arr1, 5);
		displayResults(result==1, "testCountEqualTo2");
		
		int[] arr2 = {8, 2, 6, 2, 5, 3, 2, 7, 3};
		result = RecursionExercises.countEqualTo(arr2, 1);
		displayResults(result==0, "testCountEqualTo3");
		result = RecursionExercises.countEqualTo(arr2, 2);
		displayResults(result==3, "testCountEqualTo4");
		result = RecursionExercises.countEqualTo(arr2, 3);
		displayResults(result==2, "testCountEqualTo5");
	}

	public static void testAllAbove() {
		boolean result = false;
		
		int[] arr0 = {};
		result = RecursionExercises.allAbove(arr0, 2);
		displayResults(result==true, "testAllAbove0");
		
		int[] arr1 = {3};
		result = RecursionExercises.allAbove(arr1, 2);
		displayResults(result==true, "testAllAbove1");
		result = RecursionExercises.allAbove(arr1, 3);
		displayResults(result==false, "testAllAbove2");
		
		int[] arr2 = {13, 8, 24, 10, 9};
		result = RecursionExercises.allAbove(arr2, 7);
		displayResults(result==true, "testAllAbove3");
		result = RecursionExercises.allAbove(arr2, 8);
		displayResults(result==false, "testAllAbove4");
	}

	public static void testThreeXInARow() {
		boolean result = false;
		
		int[] arr0 = {};
		result = RecursionExercises.threeXInARow(arr0, 2);
		displayResults(result==false, "threeXInARow(arr0, 2)");

		int[] arr1 = {9, 9, 9};
		result = RecursionExercises.threeXInARow(arr1, 2);
		displayResults(result==false, "threeXInARow(arr1, 2)");

		result = RecursionExercises.threeXInARow(arr1, 9);
		displayResults(result==true, "threeXInARow(arr1, 9)");
		
		int[] arr2 = {1, 2, 2, 2, 1};
		result = RecursionExercises.threeXInARow(arr2, 2);
		displayResults(result==true, "threeXInARow(arr2, 2)");
		
		result = RecursionExercises.threeXInARow(arr2, 1);
		displayResults(result==false, "threeXInARow(arr2, 1)");
			
		int[] arr3 = {8, 8, 7, 7, 8, 8, 7, 7, 8, 8};
		result = RecursionExercises.threeXInARow(arr3, 7);
		displayResults(result==false, "threeXInARow(arr3, 7)");
		
		result = RecursionExercises.threeXInARow(arr3, 8);
		displayResults(result==false, "threeXInARow(arr3, 8)");

		int[] arr4 = {8, 8, 8, 7, 7, 8, 8, 7, 7, 8, 8};
		result = RecursionExercises.threeXInARow(arr4, 7);
		displayResults(result==false, "threeXInARow(arr4, 7)");

		result = RecursionExercises.threeXInARow(arr4, 8);
		displayResults(result==true, "threeXInARow(arr4, 8)");
		
		int[] arr5 = {8, 8, 7, 7, 8, 8, 7, 7, 8, 8, 8};
		result = RecursionExercises.threeXInARow(arr5, 7);
		displayResults(result==false, "threeXInARow(arr5, 7)");

		result = RecursionExercises.threeXInARow(arr5, 8);
		displayResults(result==true, "threeXInARow(arr5, 8)");

	}

	public static void testThreeInARow() {
		boolean result = false;
		
		int[] arr0 = {};
		result = RecursionExercises.threeInARow(arr0);
		displayResults(result==false, "threeInARow(arr0)");

		int[] arr1 = {9, 9, 9};
		result = RecursionExercises.threeInARow(arr1);
		displayResults(result==true, "threeInARow(arr1)");
		
		int[] arr2 = {1, 2, 2, 2, 1};
		result = RecursionExercises.threeInARow(arr2);
		displayResults(result==true, "threeInARow(arr2)");
		
		int[] arr3 = {1, 1, 2, 2, 3, 3};
		result = RecursionExercises.threeInARow(arr3);
		displayResults(result==false, "threeInARow(arr3)");
		
		int[] arr4 = {8, 8, 8, 7, 7, 6, 5, 1, 2, 3, 3, 4, 4};
		result = RecursionExercises.threeInARow(arr4);
		displayResults(result==true, "threeInARow(arr4)");
		
		int[] arr5 = {8, 8, 7, 7, 8, 8, 7, 7, 8, 8};
		result = RecursionExercises.threeInARow(arr5);
		displayResults(result==false, "threeInARow(arr5)");
		
		int[] arr6 = {8, 8, 7, 7, 8, 8, 7, 7, 8, 8, 8};
		result = RecursionExercises.threeInARow(arr6);
		displayResults(result==true, "threeInARow(arr6)");
	}

	public static void testNInARow() {
		boolean result = false;
		
		int[] arr0 = {};
		result = RecursionExercises.nInARow(arr0, 0);
		displayResults(result==true, "nInARow(arr0, 0)");
		
		result = RecursionExercises.nInARow(arr0, 1);
		displayResults(result==false, "nInARow(arr0, 1)");

		int[] arr1 = {9, 9, 9};
		result = RecursionExercises.nInARow(arr1, 2);
		displayResults(result==true, "nInARow(arr1, 2)");

		result = RecursionExercises.nInARow(arr1, 3);
		displayResults(result==true, "nInARow(arr1, 3)");
		
		result = RecursionExercises.nInARow(arr1, 4);
		displayResults(result==false, "nInARow(arr1, 4)");
		
		
		int[] arr2 = {1, 2, 2, 2, 1};
		result = RecursionExercises.nInARow(arr2, 3);
		displayResults(result==true, "nInARow(arr2, 3)");
		
		result = RecursionExercises.nInARow(arr2, 4);
		displayResults(result==false, "nInARow(arr2, 4)");
		
		
		int[] arr3 = {1, 1, 2, 2, 3, 3};
		result = RecursionExercises.nInARow(arr3, 2);
		displayResults(result==true, "nInARow(arr3, 2)");
		
		result = RecursionExercises.nInARow(arr3, 3);
		displayResults(result==false, "nInARow(arr3, 3)");
		
		
		int[] arr4 = {8, 8, 8, 7, 7, 6, 5, 1, 2, 3, 3, 4, 4};
		result = RecursionExercises.nInARow(arr4, 2);
		displayResults(result==true, "nInARow(arr4, 2)");
		
		result = RecursionExercises.nInARow(arr4, 3);
		displayResults(result==true, "nInARow(arr4, 3)");
		
		result = RecursionExercises.nInARow(arr4, 4);
		displayResults(result==false, "nInARow(arr4, 4)");
		
		
		int[] arr5 = {8, 8, 7, 7, 8, 8, 7, 7, 8, 8};
		result = RecursionExercises.nInARow(arr5, 1);
		displayResults(result==true, "nInARow(arr5, 3)");
		
		result = RecursionExercises.nInARow(arr5, 2);
		displayResults(result==true, "nInARow(arr5, 3)");
		
		result = RecursionExercises.nInARow(arr5, 3);
		displayResults(result==false, "nInARow(arr5, 3)");
		
		
		int[] arr6 = {8, 8, 7, 7, 8, 8, 7, 7, 8, 8, 8};
		result = RecursionExercises.nInARow(arr6, 2);
		displayResults(result==true, "nInARow(arr6, 2)");
		
		result = RecursionExercises.nInARow(arr6, 3);
		displayResults(result==true, "nInARow(arr6, 3)");
		
		result = RecursionExercises.nInARow(arr6, 4);
		displayResults(result==false, "nInARow(arr6, 4)");
		
	}

	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testName);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
}