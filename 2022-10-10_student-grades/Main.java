import java.util.ArrayList;

public class Main {
    public static final String[] SUBJECTS = {"Subject 1", "Subject 2", "Subject 3", "Subject 4", "Subject 5"};

    public static final String[] STUDENTS = {"Student 1", "Student 2", "Student 3", "Student 4"};

    public static void main(String[] args) {
        var students = new ArrayList<Student>();

        System.out.println("========\nStudents\n========");

        for (var student : STUDENTS) students.add(new Student(student));

        System.out.println("\n=======\nResults\n=======");

        for (var student : students) {
            System.out.println("\n" + student.name);
            System.out.println("-".repeat(student.name.length()));
            System.out.println("Highest Grade: " + student.getHighestGrade());
            System.out.println("Lowest Grade: " + student.getLowestGrade());
            System.out.println("Average Grade: " + student.getAverageGrade());
        }
    }
}