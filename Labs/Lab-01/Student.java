/*
* Student.java
* A Student class
*/
public class Student {

	private String sID;
	private int grade;

	public Student() {
		sID = "";
		grade = -1;
	}

	public Student(String sID, int grade) {
		this.sID = sID;
		this.grade = grade;
	}
	
	public String getSID() {
		return this.sID;
	}
	
	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int g){
		this.grade = g;
	}

	public void setSID (String s){
		this.sID = s;
	}

	public String toString(){
		return this.sID + ": " + this.grade + "%";
	}
	public Boolean equals(Student other){
		if (this.sID != other.getSID()){
			return false;
		}
		if (this.grade != other.getGrade()){
			return false;
		}
		return true;
	}

}
