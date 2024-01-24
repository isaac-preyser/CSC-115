

public class Student {

    private String sID;
    private int grade;

    public Student(String id, int studentGrade) {
        sID = id;
        grade = studentGrade;
    }

    public Student() {
        sID = "";
        grade = -1;
    }

    public String getSID() {
        return sID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int studentGrade) {
        grade = studentGrade;
    }

    public boolean equals(Student other) {
        return this.sID.equals(other.sID) && this.grade==other.grade;
    }
}
