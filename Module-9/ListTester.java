public class ListTester {
	private static int testPassCount = 0;
	private static int testCount = 0;	
	
	public static void main (String[] args) {

		LinkedList<Integer> myList = new LinkedList<Integer>();
		String result = "";
		String expected = "";

		System.out.println("created and empty list:");
		result = myList.toString();
		expected = "list contents:";
		displayResults(result.equals(expected), "empty list contents");
		
		myList.addFront(10);
		result = myList.toString();
		expected = "list contents: 10";
		displayResults(result.equals(expected), "list contents");
		
		myList.addBack(20);
		result = myList.toString();
		expected = "list contents: 10 20";
		displayResults(result.equals(expected), "list contents");
		
		myList.addFront(30);
		result = myList.toString();
		expected = "list contents: 30 10 20";
		displayResults(result.equals(expected), "list contents");

		int returned = 0;
		
		returned = myList.get(2);
		displayResults(returned==20, "get at position 2");
		
		
		//out of bounds on a zero-indexed list of length 3. 
		//the list must be elongated, or the call should be changed. 
		try {
			returned = myList.get(3);
		} catch (Exception e) {
			System.out.println("Exception: "+ e + " (array out of bounds)");
			//code updated to handle the exception. 
			//we should have the test reflect this. 
			displayResults(false, "get at position 3");
		}
		
		
		System.out.println("PASSED " + testPassCount + " / " + testCount);
    }
	
	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testCount);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
}