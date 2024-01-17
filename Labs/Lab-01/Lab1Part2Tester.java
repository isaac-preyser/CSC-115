/*
 * Lab1Part2Tester.java
 *
 * A tester for the methods in your Student class
 *
 */
public class Lab1Part2Tester {

	public static void main(String[] args) {
		testConstructorsAndGetters();
		testSettersAndGetters();
		testToString();
	}

	public static void testConstructorsAndGetters() {

		// 1)
		// Tests constructor with no arguments, getSID and getGrade
		// TODO: once you have completed the getSID and getGrade methods
		// uncomment the following to test your implementation
	
	
		Student s1 = new Student();
		System.out.println("sID of student with default constructor: " + s1.getSID());
		System.out.println("grade of student with default constructor: " + s1.getGrade());

		Student s2 = new Student("V00923094", 85);
		System.out.println("sID of student with custom constructor: " + s2.getSID());
		System.out.println("grade of student with custom constructor: " + s2.getGrade());
	
		
	}

	public static void testSettersAndGetters(){
		// 2) 
		// TODO: implement and then call the setSID and setGrade methods
		// Hint: use getSID and getGrade methods to get the updated values
		
		System.out.println("\nOriginal information for student:");
		Student s2 = new Student("V00923094", 85);
		System.out.println("sID of student: " + s2.getSID());
		System.out.println("grade of student: " + s2.getGrade());
		
		// change the sID and/or the grade for student s2 here
		s2.setGrade(400);
		s2.setSID("john");
		
		System.out.println("\nUpdated information for student:");
		System.out.println("sID of student: " + s2.getSID());
		System.out.println("grade of student: " + s2.getGrade());
		//WHY IS TYPE STRING CAPITALIZED (real ones use char cat[] = {'c', 'a', 't', '\0'};)

		
	}

	public static void testToString() {
		// 3)
		// TODO: once you have written toString in the Student class,
		Student s1 = new Student("Mike Wasowski", -43);
		System.out.println(s1.toString()); //give me printf back please
		Student s2 = new Student("Bob", 54);
		Student s3 = new Student("Bob", 54);
		// create a student object and test the toString method

		System.out.println("Testing .equals:");
		System.out.println("Does " + s2.toString() + " == " +  s3.toString() + "?\n" + s2.equals(s3));
		System.out.println("Does " + s1.toString() + " == " +  s3.toString() + "?\n" + s1.equals(s3));
	}
}
