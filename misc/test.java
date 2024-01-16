package misc;
public class test {
    public static void main(String[] args) {
        Student stdnt1 = new Student("V00123456", 91);
        Student stdnt2 = new Student("V00123456", 91);
        System.out.println(stdnt1.equals(stdnt2));
        
    }
}