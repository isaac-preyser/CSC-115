public class Hashtable{
    
private static final int TABLE_SZ = 7; // a prime number

	Student[] table;
	int count;  // number of Students in the table

	public Hashtable() {
		table = new Student[TABLE_SZ];
		count = 0;
	}



	/* MethodName: insertCollisions
	 * Purpose: insert (or update entry) s in this Hashtable with no collision handling strategy
	 * Parameters: Student - s
	 * Throws:  TableFullException - if inserting a new key into a full table
	 *          CollisionException - if inserting a new key into table at index that is full
	 * Returns: nothing
	 */

	public void insertCollisions(Student s) throws TableFullException, CollisionException{
		// find the index to insert s 
		int idx = s.hashCode() % TABLE_SZ;
		// if the hashcodes are equal at the index, update the grade (don't check if the value is null). 
		if (table[idx] != null && table[idx].hashCode() == s.hashCode()) {
			table[idx].setGrade(s.getGrade());
			return;
		} 
		//if the table is full, throw a TableFullException
		if (count == TABLE_SZ) {
			throw new TableFullException();
		}

		// if the index is empty, insert s
		if (table[idx] == null) {
			table[idx] = s;
			count++;
			return;
		}
		// if the index is full, throw a CollisionException
		if (table[idx] != null) {
			throw new CollisionException();
		} 

		
	}


	/* MethodName: getCollisions
	 * Purpose: find Student with sid in this Hashtable with no collision handling and returns their grade
	 * Parameters: String - sid
	 * Throws:  KeyNotFoundException  - if Student with sid is not found in table
	 * Returns: int - the grade of Student with sid
	 */
	public int getCollisions(String sid) throws KeyNotFoundException{
		int grade = -1; // return -1 if not found
		// find the index to insert s
		int idx = sid.hashCode() % TABLE_SZ;
		// if the hashcodes are equal at the index, return the grade
		if (table[idx] != null && table[idx].getSID().hashCode() == sid.hashCode()) {
			grade = table[idx].getGrade();
			return grade;
		} else {
			//throw a KeyNotFoundException
			throw new KeyNotFoundException();
		} 
	}


	/* MethodName: insertLinearProbing
	 * Purpose: insert (or update entry) s in this Hashtable with Linear Probing to handle collisions
	 * Parameters: Student - s
	 * Throws: TableFullException  - if inserting a new key into a full table
	 * Returns: nothing
	 */
	// TODO: complete this function
	public void insertLinearProbing(Student s) throws TableFullException{
		// find the index to insert s 
		int idx = s.hashCode() % TABLE_SZ;
		// if the hashcodes are equal at the index, update the grade (don't check if the value is null). 
		if (table[idx] != null && table[idx].hashCode() == s.hashCode()) {
			table[idx].setGrade(s.getGrade());
			return;
		} 
		//if the table is full, throw a TableFullException
		if (count == TABLE_SZ) {
			throw new TableFullException();
		}

		// if the index is empty, insert s
		if (table[idx] == null) {
			table[idx] = s;
			count++;
			return;
		}
		// if the index is full, use linear probing to find the next empty index
		if (table[idx] != null) {
			int i = idx;
			while (table[i] != null) {
				i = (i + 1) % TABLE_SZ;
			}
			table[i] = s;
			count++;
		} 
	}



	/* getLinearProbing
	 * Purpose: find Student with sid in this Hashtable that uses Linear Probing and returns their grade
	 * Parameters: String - sid
	 * Throws:  KeyNotFoundException  - if Student with sid is not found in table
	 * Returns: int - the grade of Student with sid
	 */
	// TODO: complete this function
	int getLinearProbing(String sid) throws KeyNotFoundException{
		int grade = -1; // return -1 if not found
		// find the index to insert s
		int idx = sid.hashCode() % TABLE_SZ;
		for (int i = 0; i < TABLE_SZ; i++){
			// if the hashcodes are equal at the index, return the grade 
			if (table[(idx + i) % TABLE_SZ] != null && table[(idx + i) % TABLE_SZ].getSID().hashCode() == sid.hashCode()) {
				grade = table[(idx + i) % TABLE_SZ].getGrade();
				return grade;
			}
		}
		//if we exit this loop without returning a grade, throw the exception. 
		throw new KeyNotFoundException(); 
	}

	/*
	 * Purpose: returns the number of elements in this Hashtable
	 * Parameters: none
	 * Returns: int - the number of elements
	 */
	public int size() {
		return count;
	}

	/*
	 * Purpose: returns a String reprensentation of elements
	 *      in this Hashtable separated by newlines
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		String s = "";

		for(int i=0; i<TABLE_SZ; i++) {
			if (table[i] != null) {
				s  += table[i] + "\n";
			}
		}
		
		return s;
	}
    

}
