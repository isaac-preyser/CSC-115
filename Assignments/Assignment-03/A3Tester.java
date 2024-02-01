/*
 * A3Tester
 *
 * A class to test the methods required for Assignment 3
 *
 */
public class A3Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

    public static void main(String[] args) {
		
		/*
		Uncomment each method one at a time, 
		and implement the method in A3LinkedList.java 
		until all tests pass. It is strongly
		recommended that you add additional tests 
		to ensure the correctness of your implementation.
		*/
		
		/* Part 1: */
		testAddFront();
		testAddBack();
		testSizeAndIsEmpty();
		testRemoveFront();
		testRemoveBack();
		
		/* Part 2 */
		testRemoveMiddle();
		testInterleave();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }
	
		
	public static void testAddFront() {
		System.out.println("\nTesting addFront...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddFront");
		
		list1.addFront("A");
		result = list1.frontToBack();
		displayResults(result.equals("{A}"), "testAddFront");
		
		list1.addFront("V");
		list1.addFront("A");
		list1.addFront("J");
		result = list1.frontToBack();
		displayResults(result.equals("{JAVA}"), "testAddFront");
		result = list1.backToFront();
		displayResults(result.equals("{AVAJ}"), "testAddFront");
	}
	
	public static void testAddBack() {
		System.out.println("\nTesting addBack...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddBack");
		
		list1.addBack("F");
		result = list1.frontToBack();
		displayResults(result.equals("{F}"), "testAddBack");
		
		list1.addBack("U");
		list1.addBack("N");
		result = list1.frontToBack();
		displayResults(result.equals("{FUN}"), "testAddBack");
		result = list1.backToFront();
		displayResults(result.equals("{NUF}"), "testAddBack");
	}
	
	public static void testSizeAndIsEmpty() {
		System.out.println("\nTesting size and isEmpty...");
		int result = 0;
		A3LinkedList list1 = new A3LinkedList();

		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");
		
		list1.addFront("C");
		list1.addFront("S");
		list1.addFront("C");
		result = list1.size();
		displayResults(result==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");
		
		list1.addBack("115");
		result = list1.size();
		displayResults(result==4, "testSizeAndIsEmpty");
		
	}
	
	public static void testRemoveFront() {
		System.out.println("\nTesting removeFront...");
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveFront");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{INK}"), "testRemoveFront");
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly.
		
		   You should also ensure that your size and isEmpty 
		   methods work with removal as well as addition */

		//test removeFront on empty list
		list1 = new A3LinkedList();
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront on empty list");

		//test removeFront on length 1 list
		list1 = new A3LinkedList();
		list1.addBack("A");
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testRemoveFront on length 1 list");

		//test removeFront on length 2 list
		list1 = new A3LinkedList();
		list1.addBack("A");
		list1.addBack("B");
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{B}"), "testRemoveFront on length 2 list");
		
				
	}
	
	public static void testRemoveBack() {
		System.out.println("\nTesting removeBack...");
		// Write all of your own tests here 

		//test removing null list
		A3LinkedList list1 = new A3LinkedList();
		list1.removeBack();
		String result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeBack called on empty list");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeBack called on empty list");

		//test removing length 1 list
		list1 = new A3LinkedList();
		list1.addBack("A");
		list1.removeBack();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeBack called on length 1 list");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeBack called on length 1 list");

		//test removing length 2 list
		list1 = new A3LinkedList();
		list1.addBack("A");
		list1.addBack("B");
		list1.removeBack();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{A}"), "frontToBack after removeBack called on length 2 list");
		result1 = list1.backToFront();

		
	}
	
	public static void testRemoveMiddle() {
		System.out.println("\nTesting removeMiddle...");
		
		A3LinkedList list1 = new A3LinkedList();
		String result1 = "";
		// list1.addBack("T");
		// list1.addBack("A");
		// list1.addBack("B");
		// list1.addBack("L");
		// list1.addBack("E");
		
		// list1.removeMiddle();
		// result1 = list1.frontToBack();
		// displayResults(result1.equals("{TALE}"), "frontToBack after removeMiddle called on TABLE");
		// result1 = list1.backToFront();
		// displayResults(result1.equals("{ELAT}"), "backToFront after removeMiddle called on TABLE");
		
		
		list1 = new A3LinkedList();
		list1.addBack("B");
		list1.addBack("E");
		list1.addBack("T");
		list1.addBack("T");
		list1.addBack("E");
		list1.addBack("R");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{BEER}"), "frontToBack after removeMiddle called on BETTER");
		result1 = list1.backToFront();
		displayResults(result1.equals("{REEB}"), "backToFront after removeMiddle called on BETTER");
		
		list1 = new A3LinkedList();
		list1.addBack("A");
		
		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeMiddle called on length 1");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeMiddle called on length 1");
		
		// Write additional tests here to ensure all of your pointers
		// and other fields have been updated correctly.

		// Test with a list of length 2
		list1 = new A3LinkedList();
		list1.addBack("A");
		list1.addBack("B");

		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeMiddle called on length 2");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeMiddle called on length 2");

		// Test with a list of length 3
		list1 = new A3LinkedList();
		list1.addBack("A");
		list1.addBack("B");
		list1.addBack("C");

		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{AC}"), "frontToBack after removeMiddle called on length 3");
		result1 = list1.backToFront();
		displayResults(result1.equals("{CA}"), "backToFront after removeMiddle called on length 3");

		// Test with a list of length 0 (empty list)
		list1 = new A3LinkedList();

		list1.removeMiddle();
		result1 = list1.frontToBack();
		displayResults(result1.equals("{}"), "frontToBack after removeMiddle called on empty list");
		result1 = list1.backToFront();
		displayResults(result1.equals("{}"), "backToFront after removeMiddle called on empty list");
				
	}
	
	
	public static void testInterleave() {
		System.out.println("\nTesting interleave...");
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		String result1 = "";
		String result2 = "";
		
		list1.addBack("A");
		list1.addBack("B");
		list1.addBack("C");
		list1.addBack("D");
		list1.addBack("E");
		list1.addBack("F");
		list1.addBack("G");
		result1 = list1.frontToBack();
		displayResults(result1.equals("{ABCDEFG}"), "testInterleave, original first list is ABCDEFG");
		System.out.println(list1.frontToBack());

		list2.addBack("L");
		list2.addBack("M");
		list2.addBack("N");
		list2.addBack("O");
		list2.addBack("P");
		list2.addBack("Q");
		list2.addBack("R");
		result2 = list2.frontToBack();
		displayResults(result2.equals("{LMNOPQR}"), "testInterleave, original second list is LMNOPQR");
		System.out.println(list2.frontToBack());

		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{AMCOEQG}"), "after interleave, first list now contains AMCOEQG");
		System.out.println(list1.frontToBack());
		displayResults(result2.equals("{LBNDPFR}"), "after interleave, second list now contains LBNDPFR");
		System.out.println(list2.frontToBack());

		// Write additional tests here to ensure all of your pointers
		// have been updated correctly.

		// Test with empty list
		list1 = new A3LinkedList();
		list2 = new A3LinkedList();

		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{}"), "after interleave, first list is empty");
		displayResults(result2.equals("{}"), "after interleave, second list is empty");

		// Test with first list of length 1 and second list of length 1
		list1 = new A3LinkedList();
		list2 = new A3LinkedList();
		list1.addBack("A");
		list2.addBack("B");

		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();
		displayResults(result1.equals("{A}"), "after interleave, first list now contains AB");
		displayResults(result2.equals("{B}"), "after interleave, second list is empty");

		//uneven list lengths
		list1 = new A3LinkedList();
		list2 = new A3LinkedList();
		list1.addBack("A");
		list1.addBack("B");
		list1.addBack("C");
		list2.addBack("D");

		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();

		displayResults(result1.equals("{A}"), "after interleave, first list now contains ADBC");
		displayResults(result2.equals("{DBC}"), "after interleave, second list now contains D");

		//uneven list lengths where both are greater than 1
		list1 = new A3LinkedList();
		list2 = new A3LinkedList();

		list1.addBack("A");
		list1.addBack("B");
		list2.addBack("C");
		list2.addBack("D");
		list2.addBack("E");
		list2.addBack("F");

		list1.interleave(list2);
		result1 = list1.frontToBack();
		result2 = list2.frontToBack();

		displayResults(result1.equals("{AD}"), "after interleave, first list now contains ADBECF");
		displayResults(result2.equals("{CBEF}"), "after interleave, second list now contains DBECF");


		
	}
	
	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}
