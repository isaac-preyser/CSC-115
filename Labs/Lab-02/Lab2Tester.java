/*
 * Lab2Tester.java
 *
 * A tester for the methods in Lab2.java
 *
 */
import java.util.Arrays;

public class Lab2Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

	// for approximate comparison of floating point numbers
	private static final double THRESHOLD = 0.01;

	public static void main(String[] args) {
		
		testGetHigherGradeStudent();
		testIsGradeAbove();
		testGetClasslist();
		testCountAbove();
		testGetClassAverage();
		testRegisterStudent();

		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testGetHigherGradeStudent() {
		
		//  uncomment the following tests - make sure you understand what they are testing

		
		Student s0  = new Student("abc", 50);
		Student s1a = new Student("def", 56);
		Student s1b = new Student("xyz", 56);
		Student s2  = new Student("xyz", 99);

		Student result;

		result = Lab2.getHigherGradeStudent(s0,s1a);
		//System.out.println("should be  " + s1a + " is " + result);
		displayResults(result.equals(s1a), "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1a,s0);
		//System.out.println("should be  " + s1a + " is " + result);
		displayResults(result.equals(s1a), "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1b,s1a);
		//System.out.println("should be  " + s1b + " is " + result);
		displayResults(result.equals(s1b) && result == s1b, "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1b,s2);
		//System.out.println("should be  " + s2 + " is " + result);
		displayResults(result.equals(s2), "testGetHigherGradeStudent");
		
	}

	public static void testIsGradeAbove() {
		
		Student s0  = new Student("abc", 50);
		Student s1a = new Student("def", 56);
		Student s1b = new Student("xyz", 56);
		Student s2  = new Student("xyz", 99);

		boolean result;

		result = Lab2.isGradeAbove(s0, 50);
		displayResults(result == false, "testIsGradeAbove");

		result = Lab2.isGradeAbove(s1a, 50);
		displayResults(result == true, "testIsGradeAbove");

		result = Lab2.isGradeAbove(s1b, 50);
		displayResults(result == true, "testIsGradeAbove");

		result = Lab2.isGradeAbove(s2, 85);
		displayResults(result == true, "testIsGradeAbove");



	}

	public static void testGetClasslist() {
		
		// NOTE: the Arrays library has been imported for you.
		//       you can use the Arrays.equals method to compare
		//       2 arrays of String objects as String has a equals method
		// The API for Arrays.equals:
		//       equals(Object[] a, Object[] a2)
		//       Returns true if the two specified arrays are equal to one another.

		// uncomment the following test. We have gotten you started with 
		// some initial test data and one test, but you should consider 
		// other cases (empty array, longer array)

		
		Student s0  = new Student("abc", 50);
		Student s1a = new Student("def", 56);
		Student s1b = new Student("xyz", 56);
		Student s2  = new Student("xyz", 99);

		Student[] students1 = {s0};
		String[] expected1 = {"abc"};

		Student[] students2 = {s0, s1a, s1b};
		String[] expected2 = {"abc", "def", "xyz"};

		String[] result;

		result = Lab2.getClasslist(students1);
		displayResults(Arrays.equals(result, expected1), "testGetClasslist - 1 elements");
		
		result = Lab2.getClasslist(students2);
		displayResults(Arrays.equals(result, expected2), "testGetClasslist - 3 elements");

		//test - empty array
		Student[] students3 = {};
		String[] expected3 = {};
		result = Lab2.getClasslist(students3);
		displayResults(Arrays.equals(result, expected3), "testGetClasslist - empty array");

		//test - 4 elements
		Student[] students4 = {s0, s1a, s1b, s2};
		String[] expected4 = {"abc", "def", "xyz", "xyz"};
		result = Lab2.getClasslist(students4);
		displayResults(Arrays.equals(result, expected4), "testGetClasslist - 4 elements");
		
		


	}


	public static void testCountAbove() {
		
		Student s0  = new Student("abc", 50);
		Student s1a = new Student("def", 56);
		Student s1b = new Student("xyz", 56);
		Student s2  = new Student("xyz", 99);

		//testing threshold 50 - should test other thresholds for coverage but YOLO

		Student[] students1 = {s0};
		int expected1 = 0;

		Student[] students2 = {s0, s1a, s1b};
		int expected2 = 2;

		Student[] students3 = {s0, s2, s1a, s1b};
		int expected3 = 3;

		int result;

		result = Lab2.countAbove(students1, 50);
		displayResults(result == expected1, "testCountAbove - 1 elements");

		result = Lab2.countAbove(students2, 50);
		displayResults(result == expected2, "testCountAbove - 3 elements");

		result = Lab2.countAbove(students3, 50);
		displayResults(result == expected3, "testCountAbove - 4 elements");



	}


	public static void testGetClassAverage() {
		Student s0 = new Student("abc", 50);
		Student s1 = new Student(); // considered invalid for average average calculation
		Student s2 = new Student("xyz", 99);
		Student s3 = new Student("def", 88);

		Student[] students0 = {};
		Student[] students1 = {s0};
		Student[] students2 = {s0, s1, s2};
		Student[] students3 = {s0, s2, s3};

		double result = 0.0;
		double expected = 0.0;
		
		// Some of you noticed in Lab1 that floating point arithmetic sometimes
		// produces results with many decimals places. We use the threshold
		// (defined as a global variable at the top) to specify the margin 
		// of error we are okay with, and just make sure the expected and 
		// returned results are within the threshold of acceptable error.

		
		result = Lab2.getClassAverage(students0);
		expected = 0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - empty");

		result = Lab2.getClassAverage(students1);
		expected = 50.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - 1 student");

		result = Lab2.getClassAverage(students2);
		expected = (50 + 99) / 2.0; // because s1 does not have a "real" grade
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - 3 students, count 2");

		result = Lab2.getClassAverage(students3);
		expected = (50 + 99 + 88) / 3.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - 3 students, count 3");
        
	}

	public static void testRegisterStudent() {
		
		// HINT: the Student class also has a equals method so you
		// can use Arrays.equals again to compare 2 Student arrays

		Student s0  = new Student("abc", 50);
		Student s1a = new Student("def", 56);
		Student s1b = new Student("xyz", 56);
		Student s2  = new Student("xyz", 99);

		Student[] students0 = {};
		Student[] students1 = {s0};
		Student[] students2 = {s0, s1a, s2};
		Student[] students3 = {s0, s1b, s2};

		Student n = new Student("jeffery james sr.", 13); // jeff james is not so bright

		Student[] result;  

		//test 1 - empty array
		Student[] expected1 = {n};
		result = Lab2.registerStudent(students0, n);
		displayResults(Arrays.equals(result, expected1), "Empty Array");


		//test 2 - students1 
		Student[] expected2 = {s0, n};
		result = Lab2.registerStudent(students1, n);
		displayResults(Arrays.equals(result, expected2), "1 student");

		//test 3 - students2
		Student[] expected3 = {s0, s1a, s2, n};
		result = Lab2.registerStudent(students2, n);
		displayResults(Arrays.equals(result, expected3), "3 students");

		//test 4 - students3
		Student[] expected4 = {s0, s1b, s2, n};
		result = Lab2.registerStudent(students3, n);
		displayResults(Arrays.equals(result, expected4), "3 students, again");

		

	}
	


	public static void displayResults (boolean passed, String testName) {
		/* There is some magic going on here getting the line number
		 * Borrowed from:
		 * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
		 */
		
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
