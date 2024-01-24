/*
 * Lab2.java
 *
 * A class of static methods that operate on Students
 *
 */
public class Lab2 {
    
	/*
	 * Purpose: determines which student has the higher grade
	 * Parameters: Student - s1, Student - s2
	 * Returns: Student - the Student with the higher grade,
	 *                    s1 if they have the same grade
	 * Precondition: s1 and s2 are not null
	 */
	public static Student getHigherGradeStudent(Student s1, Student s2) {
		Student result; 
		result = s1.getGrade() >= s2.getGrade() ? s1 : s2; // we love ternary operators :)
		return result; // so it compiles
	}


	/*
	 * Purpose: determines whether the grade of Student s
	 *          is above the threshold
	 * Parameters: Student - s, int - threshold
	 * Returns: boolean - true if grade is above threshold, false otherwise
	 * Preconditions: s is not null
	 */
	// TODO: implement isGradeAbove
	public static boolean isGradeAbove(Student s, int threshold) {
		return s.getGrade() > threshold;
	}


	/*
	 * Purpose: creates an array sIDs of all Students in students
	 * Parameters: Student[] - students
	 * Returns: String[] - array of sIDs
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement getClasslist
	public static String[] getClasslist(Student[] students) {
		String[] result = new String[students.length];
		for (int i = 0; i < students.length; i++) {
			result[i] = students[i].getSID();
		}
		return result;
	}


	/*
	 * Purpose: counts the number of Students in students
	 *          with grade above threshold
	 * Parameters: Student[] - students, int - threshold
	 * Returns: int - the number of students with a grade above threshold
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement countAbove
	// HINT: you should be using the isGradeAbove method!

	public static int countAbove(Student[] students, int threshold) {
		int count = 0;
		for (Student s : students) /* Trying out new syntax */ {
			if (isGradeAbove(s, threshold)) {
				count++;
			}
		}
		return count;
	}


	/*
	 * Purpose: calculates the average grade of Students in students,
	 *          does NOT include students with -1 grade in calculation
	 *          average is 0.0 if students is empty or all students have -1 grade
	 * Parameters: Student[] - students
	 * Returns: double - the average grade
	 * Preconditions: students is not null and contains no null elements
	 */
	// TODO: implement getClassAverage
	// HINT: you can use the isGradeAbove method again
	public static double getClassAverage(Student[] students) {
		int sum = 0;
		int count = 0;
		for (Student s : students) {
			// I really like this for-each syntax ... 
			if (s.getGrade() != -1) {
				sum += s.getGrade(); 
				count++;
			}
		}
		
		//System.out.println(sum + " / " + count + " = " + sum / (double) count);
		//practice ternary operators. 
		//if count != 0, do normal calculation, else result = 0.
		return count != 0 ? sum / (double) count : 0.0; //casted so we don't lose precision to integer division
	}


	/*
	 * Purpose: creates a new array 1 longer than students
	 *          and adds all students and s to the new array
	 * Parameters: Student[] - students, Student s
	 * Returns: Student[] - the new array
	 * Preconditions: students is not null and contains no null elements
	 *                Student s is not already contained within students
	 */
	// TODO: implement registerStudent
	// PLEASE LET US USE LIST<T> FOR THIS 
	public static Student[] registerStudent(Student[] students, Student s){
		Student[] result = new Student[students.length + 1];
		//copy all students into array, and then add s to the end. 
		System.arraycopy(students, 0, result, 0, students.length);
		//add s to the end. 
		result[result.length - 1] = s; //arrays are zero-indexed so we need the shift left
		return result; 
	}


}
