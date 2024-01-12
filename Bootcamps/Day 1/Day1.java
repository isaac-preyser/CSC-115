//import java.util.LinkedList;

public class Day1 {

	public static void main(String[] args) {
		// Call the methods you complete from the 
		// main method to determine if they work correctly.
		System.out.println("Testing printMax(3, 5): \tExpected: 5 \tTest: " + printMax(3, 5));
		System.out.println("Testing printmax(5, 3): \tExpected: 5 \tTest: " + printMax(5, 3));
		System.out.println("Testing printmax(5, 5): \tExpected: 5 \tTest: " + printMax(5, 5));

		System.out.println("Testing isSpecial(3): \tExpected: 1 \tTest: " + isSpecial(3));
		System.out.println("Testing isSpecial(7): \tExpected: 1 \tTest: " + isSpecial(7));
		System.out.println("Testing isSpecial(21): \tExpected: 1 \tTest: " + isSpecial(21));
		System.out.println("Testing isSpecial(2): \tExpected: -1 \tTest: " + isSpecial(2));
		System.out.println("Testing isSpecial(4): \txpected: -1 \tTest: " + isSpecial(4));

		System.out.println("Testing countSpecialToN(10): \tExpected: 4 \tTest: " + countSpecialToN(10));
		System.out.println("Testing countSpecialToN(20): \tExpected: 8 \tTest: " + countSpecialToN(20));
		System.out.println("Testing countSpecialToN(30): \tExpected: 12 \tTest: " + countSpecialToN(30));

		System.out.println("Testing getFibonacci(1): \tExpected: 1 \tTest: " + getFibonacci(1));
		System.out.println("Testing getFibonacci(2): \tExpected: 1 \tTest: " + getFibonacci(2));
		System.out.println("Testing getFibonacci(3): \tExpected: 2 \tTest: " + getFibonacci(3));
		System.out.println("Testing getFibonacci(4): \tExpected: 3 \tTest: " + getFibonacci(4));
		System.out.println("Testing getFibonacci(5): \tExpected: 5 \tTest: " + getFibonacci(5));
		System.out.println("Testing getFibonacci(6): \tExpected: 8 \tTest: " + getFibonacci(6));

		//testing getLeftDigit
		System.out.println("Testing getLeftDigit(123): \tExpected: 1 \tTest: " + getLeftDigit(123));
		System.out.println("Testing getLeftDigit(1234): \tExpected: 1 \tTest: " + getLeftDigit(1234));
		System.out.println("Testing getLeftDigit(12345): \tExpected: 1 \tTest: " + getLeftDigit(12345));
		
		System.out.println("Testing getLeftDigit(234): \tExpected: 2 \tTest: " + getLeftDigit(234));

		System.out.println("Testing getLeftDigit(9): \tExpected: 9 \tTest: " + getLeftDigit(9));
		System.out.println("Testing getLeftDigit(99): \tExpected: 9 \tTest: " + getLeftDigit(99));

		//testing printBox
		System.out.println("Testing printBox(3, 3): \tExpected: \n***\n***\n***\nTest: ");
		printBox(3, 3);
		System.out.println("Testing printBox(5, 5): \tExpected: \n*****\n*****\n*****\n*****\n*****\nTest: ");
		printBox(5, 5);

		//testing printPattern
		System.out.println("Testing printPattern(3): \tExpected: \n*\n**\n***\nTest: ");
		printPattern(3);
		System.out.println("Testing printPattern(5): \tExpected: \n*\n**\n***\n****\n*****\nTest: ");
		printPattern(5);
		return;
	}
	
	// 1) Design a method named printMax that takes two 
	// integers and outputs the maximum value.
	public static int printMax(int a, int b){ 
		if (a > b){
			return a;
		} else {
			return b;
		}
		
	}
	

	// 2) Design a method named isSpecial, that takes an
	// integer and determines if it is special 
	//
	// Assume an integer is special if it is divisible
	// by 3 or 7 (or both).
	public static int isSpecial(int n){
		if (n % 3 == 0 || n % 7 == 0){
			//System.out.println(n + " is special!");
			return 1; 
		} else {
			//System.out.println(n + " is not special.");
			return -1; 
		}
		
	}


	// 3) Design a method named countSpecialToN, that takes
	// an integer n and determines how many special
	// integers there are between 1 and n (inclusive).
	//
	// This method MUST call the method you designed in 2)
	public static int countSpecialToN(int n){
		int numSpecial = 0; 
		for (int i = 1; i < n; i++){
			if (isSpecial(i) == 1){
				//the number is special. 
				numSpecial++;
				//System.out.println(i + " is special!");
			} else {
				//number isnt special, do nothing.
				continue; //redundant but whatver
			}
		}
		//System.out.println("There are " + numSpecial + " special numbers from 0 to " + n + ".");
		return numSpecial; 
	}


	// 4) Design a method named getFibonacci that takes
	// an integer n and returns the nth term in the 
	// Fibonacci sequence. 
	//
	// In the Fibonacci sequence, the first two terms
	// are 1, and every term following is the sum of the 
	// two previous terms. For example: 1 1 2 3 5 8 13 21 34...
	public static int getFibonacci(int n){
		int[] fib = new int[n+2];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i < n+2; i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n-1];

	}


	// 5) Design a method named getLeftDigit that takes 
	// an integer and returns the leftmost digit.
	//
	// For example: if given 8,432,590, then 8 would be
	// returned, as it is the leftmost digit.
	//
	// You must use a while-loop in your solution.

	public static int getLeftDigit(int n){
		int working = n; 
		while (working > 9){
			working /= 10; 
		}
		
		return working; 
	}

	// 6) Design a method named printBox that takes two 
	// integers representing the height and width of a 
	// box. The method should output a box with the
	// correct dimensions.
	//
	// For example, printBox(6,3) outputs:
	// ***
	// ***
	// ***
	// ***
	// ***
	// ***
	public static void printBox(int x, int y){
		for (int i = 0; i < x; i++){
			for (int j = 0; j < y; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		return; 
	}


	// 7) Design a method named printPattern that an 
	// integer n representing the size of the pattern
	// to output. The method outputs a triangle n
	// lines long. 
	//
	// For example, printPattern(5) outputs:
	// *
	// **
	// ***
	// ****
	// *****
	public static void printPattern (int n){
		for (int i = 0; i < n; i++){
			for (int j = 0; j < i+1; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		return; 
	}

	
}
