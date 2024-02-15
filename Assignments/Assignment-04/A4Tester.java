public class A4Tester {
	private static int testPassCount = 0;
	private static int testCount = 0;
	
	public static void main (String[] args)	{
		testCount = 0;
		testPassCount = 0;
		
		/* Part 1: Using the List ADT */		
		testCompetitorsCount();
		testCountScoresAboveX();
		testDistanceAway();
		testGetBestCompetitorName();
		testNumberTimesRecordBroken();
		testListOfRecordBreakers();
		
		/* Part 2: Implementing the Generic Stack ADT */
		testStackOperations();
		testStackIsGeneric();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	

	public static void testCompetitorsCount() {
		System.out.println("\nTesting competitorsCount...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.competitorsCount(list1);
		expected = 1;
		displayResults(result == expected, "competitorsCount(list1)");
		
		result = A4Exercises.competitorsCount(list2);
		expected = 4;
		displayResults(result == expected, "competitorsCount(list2)");
		
		result = A4Exercises.competitorsCount(list3);
		expected = 12;
		displayResults(result == expected, "competitorsCount(list3)");
		
		// Add tests until you are sure your implementation 
		// produces the correct result for all inputs

	}
	
	
	public static void testCountScoresAboveX() {
		System.out.println("\nTesting countScoresAboveX...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.countScoresAboveX(list1, 30);
		expected = 1;
		displayResults(result == expected, "countScoresAboveX(list1, 30)");
		result = A4Exercises.countScoresAboveX(list1, 40);
		expected = 0;
		displayResults(result == expected, "countScoresAboveX(list1, 40)");
		
		result = A4Exercises.countScoresAboveX(list2, 40);
		expected = 2;
		displayResults(result == expected, "countScoresAboveX(list2, 40)");
		result = A4Exercises.countScoresAboveX(list2, 50);
		expected = 1;
		displayResults(result == expected, "countScoresAboveX(list2, 50)");
		
		// Add tests until you are sure your implementation 
		// produces the correct result for all inputs
		
	}


	public static void testDistanceAway() {
		System.out.println("\nTesting distanceAway...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.distanceAway(list1, c1);
		expected = 0;
		displayResults(result==expected, "distanceAway(list1, c1)");
		
		result = A4Exercises.distanceAway(list2, c2);
		expected = 3;
		displayResults(result==expected, "distanceAway(list2, c2)");
		
		result = A4Exercises.distanceAway(list3, c3);
		expected = 2;
		displayResults(result==expected, "distanceAway(list3, c3)");

		// Add tests until you are sure your implementation 
		// produces the correct result for all inputs
		
	}
	

	public static void testGetBestCompetitorName() {
		System.out.println("\nTesting getBestCompetitorName...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4};
		Competitor[] arr4 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		List list4 = new ArrayList(arr4);
		
		String result = "";
		String expected = "";
		
		result = A4Exercises.getBestCompetitorName(list1);
		expected = "Ali";
		displayResults(result.equals(expected), "getBestCompetitorName(list1)");
		
		result = A4Exercises.getBestCompetitorName(list2);
		expected = "Jo";
		displayResults(result.equals(expected), "getBestCompetitorName(list2)");

		result = A4Exercises.getBestCompetitorName(list3);
		expected = "Jo";
		displayResults(result.equals(expected), "getBestCompetitorName(list3)");
		
		result = A4Exercises.getBestCompetitorName(list4);
		expected = "Ali";
		displayResults(result.equals(expected), "getBestCompetitorName(list3)");
		
		// Write more of your own tests here
		
	}
	
	
	public static void testNumberTimesRecordBroken() {
		System.out.println("\nTesting numberTimesRecordBroken...");
		
		Competitor c1  = new Competitor("Ali",  37); // new record
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); // new record
		Competitor c4  = new Competitor("Jo",   53); // new record
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); // new record
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); // new record
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		
		int result = 0;
		int expected = 0;		
		
		result = A4Exercises.numberTimesRecordBroken(list1);
		expected = 1;
		displayResults(result==expected, "numberTimesRecordBroken(list1)");
		
		result = A4Exercises.numberTimesRecordBroken(list2);
		expected = 2;
		displayResults(result==expected, "numberTimesRecordBroken(list2)");

		result = A4Exercises.numberTimesRecordBroken(list3);
		expected = 5;
		displayResults(result==expected, "numberTimesRecordBroken(list3)");
		
		// Write more of your own tests here
		
	}

	private static boolean equal(String[] a1, String[] a2) {
		boolean equal = true;
		if ((a1 == null || a2 == null) && a1 != a2) { // one is null
			equal = false;
		} else if (a1.length != a2.length) { // different lengths
			equal = false;
		} else {
			int i = 0; 
			while (i < a1.length && equal == true) {
				if (!a1[i].equals(a2[i])) {
					equal = false;
				}
				i++;
			}
		}
		return equal;
	}

	public static void testListOfRecordBreakers() {
		System.out.println("\n Testing listOfRecordBreakers...");
		
		Competitor c1  = new Competitor("Ali",  37); 
		Competitor c2  = new Competitor("Sam",  18);
		Competitor c3  = new Competitor("Lee",  49); 
		Competitor c4  = new Competitor("Jo",   53); 
		Competitor c5  = new Competitor("Dani", 41); 
		Competitor c6  = new Competitor("Zee",  52); 
		Competitor c7  = new Competitor("Ola",  75); 
		Competitor c8  = new Competitor("Mary", 24); 
		Competitor c9  = new Competitor("Theo", 72); 
		Competitor c10 = new Competitor("Ali",  91); 
		Competitor c11 = new Competitor("Tay",  80); 
		Competitor c12 = new Competitor("Luis", 88); 
		
		Competitor[] arr1 = {c1};
		Competitor[] arr2 = {c1, c4, c3, c2};
		Competitor[] arr3 = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
		
		List list1 = new ArrayList(arr1);
		List list2 = new ArrayList(arr2);
		List list3 = new ArrayList(arr3);
		
		String[] result = null;
		String[] expected1 = {"Ali"};
		String[] expected2 = {"Ali", "Jo"};
		String[] expected3 = {"Ali", "Lee", "Jo", "Ola", "Ali"};
		
		result = A4Exercises.listOfRecordBreakers(list1);
		displayResults(equal(result,expected1), "listOfRecordBreakers(list1)");
		
		result = A4Exercises.listOfRecordBreakers(list2);
		displayResults(equal(result,expected2), "listOfRecordBreakers(list2)");
		
		result = A4Exercises.listOfRecordBreakers(list3);
		displayResults(equal(result,expected3), "listOfRecordBreakers(list3)");
		
		// Write more of your own tests here
		
	}

	public static void testStackOperations() {
		System.out.println("\nTesting stack operations...");
		A4Stack<Integer> testStack = new A4Stack<Integer>();
		Integer result = 0;
		
		displayResults(testStack.isEmpty(), "stack initially empty");
				
		testStack.push(2);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result.equals(2), "peek works after initial push");
		
		// Write more of your own tests here

		result = testStack.pop();
		displayResults(result.equals(2), "pop works after initial push");
		displayResults(testStack.isEmpty(), "stack empty after initial pop");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");
		
		testStack.push(5);
		testStack.push(7);
		result = testStack.peek();
		displayResults(result.equals(7), "peek works after two pushes");
		result = testStack.pop();
		displayResults(result.equals(7), "pop works after two pushes");
		result = testStack.pop();
		displayResults(result.equals(5), "pop works after two pushes");
		displayResults(testStack.isEmpty(), "stack empty after two pops");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");
		
		testStack.push(3);
		testStack.push(8);
		result = testStack.pop();
		displayResults(result.equals(8), "pop works after two pushes");
		result = testStack.pop();
		displayResults(result.equals(3), "pop works after two pushes");
		displayResults(testStack.isEmpty(), "stack empty after two pops");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");



		//test peek
		testStack.push(3);
		testStack.push(8);
		result = testStack.peek();
		displayResults(result.equals(8), "peek works after two pushes");
		result = testStack.pop();
		displayResults(result.equals(8), "pop works after two pushes");
		result = testStack.peek();
		displayResults(result.equals(3), "peek works after two pushes");
		result = testStack.pop();
		displayResults(result.equals(3), "pop works after two pushes");
		displayResults(testStack.isEmpty(), "stack empty after two pops");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");

		//test popAll
		testStack.push(3);
		testStack.push(8);
		testStack.popAll();
		displayResults(testStack.isEmpty(), "stack empty after popAll");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");

		//test popAll with multiple items
		testStack.push(3);
		testStack.push(8);
		testStack.push(1);
		testStack.push(5);
		testStack.push(7);
		testStack.popAll();
		displayResults(testStack.isEmpty(), "stack empty after popAll");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");
		result = testStack.pop();
		displayResults(result == null, "pop returns null when stack is empty");
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty");

		// Write more of your own tests here
		// Test pushing null
		testStack.push(null);
		result = testStack.peek();
		displayResults(result == null, "peek returns null after pushing null");
		result = testStack.pop();
		displayResults(result == null, "pop returns null after pushing null");

		// Test popping from a stack with only one item
		testStack.push(1);
		testStack.pop();
		displayResults(testStack.isEmpty(), "stack empty after popping single item");

		// Test peeking at an empty stack after having added and removed items
		testStack.push(1);
		testStack.pop();
		result = testStack.peek();
		displayResults(result == null, "peek returns null when stack is empty after pop");

		// Test pushing and popping multiple items in a different order
		testStack.push(1);
		testStack.push(2);
		testStack.pop();
		result = testStack.peek();
		displayResults(result.equals(1), "peek returns first item after second item popped");

		// Test pushing and popping a large number of items
		for (int i = 0; i < 1000; i++) {
			testStack.push(i);
		}
		for (int i = 999; i >= 0; i--) {
			result = testStack.pop();
			displayResults(result.equals(i), "pop returns correct item after pushing and popping large number of items");
		}

	}
	
	public static void testStackIsGeneric() {
		System.out.println("\nTesting generics...");
		A4Stack<Integer> s1 = new A4Stack<Integer>();
		A4Stack<String> s2 = new A4Stack<String>();
		A4Stack<Double> s3 = new A4Stack<Double>();
		
		Integer result1;
		String result2;
		Double result3;
		
		s1.push(3);
		s1.push(8);
		s2.push("CSC");
		s2.push("ENGR");
		s3.push(5.5);
		s3.push(9.1);
		
		result1 = s1.pop();
		result2 = s2.pop();
		result3 = s3.pop();
		
		displayResults(result1.equals(8), "Integer Stack");
		displayResults(result2.equals("ENGR"), "String Stack");
		displayResults(result3.equals(9.1), "Double Stack");		

		// Write more of your own tests here
		//TEST PEEK
		result1 = s1.peek();
		displayResults(result1.equals(3), "Peek works for Integer Stack");
		result2 = s2.peek();
		displayResults(result2.equals("CSC"), "Peek works for String Stack");
		result3 = s3.peek();
		displayResults(result3.equals(5.5), "Peek works for Double Stack");


		//TEST POPALL
		s1.popAll();
		displayResults(s1.isEmpty(), "popAll works for Integer Stack");
		s2.popAll();
		displayResults(s2.isEmpty(), "popAll works for String Stack");
		s3.popAll();
		displayResults(s3.isEmpty(), "popAll works for Double Stack");
		//TEST PEEK AFTER POPALL
		result1 = s1.peek();
		displayResults(result1 == null, "Peek returns null for Integer Stack after popAll");


		//TEST POPALL WITH MULTIPLE ITEMS
		s1.push(3);
		s1.push(8);
		s1.push(1);
		s1.push(5);
		s1.push(7);

		s2.push("CSC");
		s2.push("ENGR");
		s2.push("CSC");
		s2.push("ENGR");

		s3.push(5.5);
		s3.push(9.1);
		s3.push(5.5);

		s1.popAll();
		displayResults(s1.isEmpty(), "popAll works for Integer Stack with multiple items");
		s2.popAll();
		displayResults(s2.isEmpty(), "popAll works for String Stack with multiple items");
		s3.popAll();
		displayResults(s3.isEmpty(), "popAll works for Double Stack with multiple items");
		
		// Test with different types of objects
		A4Stack<Integer> integerStack = new A4Stack<Integer>();
		integerStack.push(1);
		displayResults(integerStack.peek() == 1, "Integer Stack works correctly");

		A4Stack<String> stringStack = new A4Stack<String>();
		stringStack.push("test");
		displayResults(stringStack.peek().equals("test"), "String Stack works correctly");

		A4Stack<Double> doubleStack = new A4Stack<Double>();
		doubleStack.push(1.1);
		displayResults(doubleStack.peek() == 1.1, "Double Stack works correctly");

		// Test with custom objects
		class TestObject {
			int value;
			TestObject(int value) {
				this.value = value;
			}
		}

		A4Stack<TestObject> objectStack = new A4Stack<TestObject>();
		TestObject testObject = new TestObject(1);
		objectStack.push(testObject);
		displayResults(objectStack.peek() == testObject, "Object Stack works correctly");

		// Test with null
		A4Stack<Object> nullStack = new A4Stack<Object>();
		nullStack.push(null);
		displayResults(nullStack.peek() == null, "Null Stack works correctly");


	}	
	
	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed)	{
			System.out.println ("Passed test: " + testCount);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
}