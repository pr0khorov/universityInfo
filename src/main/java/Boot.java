import model.Student;

public class Boot {
    public static void main(String[] args) {
        System.out.println("It works!");
        Student student = new Student();
        student.setAvgExamScore((float)3.5).setCurrentCourseNumber(3).setFullName("azaza").setUniversityId("123asd");
        System.out.println(student);
    }
}
