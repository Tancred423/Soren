import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Student {
    String name;
    LinkedHashMap<String, Integer> grades = new LinkedHashMap<>();

    Student(String name) {
        this.name = name;
        setupGrades();
    }

    private void setupGrades() {
        System.out.println("\n" + this.name);
        System.out.println("-".repeat(this.name.length()));

        for (var subject : Main.SUBJECTS) {
            var gradesSize = grades.size();

            while (gradesSize == grades.size()) {
                askForGrade(subject);
            }
        }
    }

    private void askForGrade(String subject) {
        var reader = new Scanner(System.in);
        System.out.print("Enter the grade for " + subject + ": ");

        try {
            var input = reader.nextInt();
            if (input > 0 && input < 7) this.grades.put(subject, input);
            else throw new InputMismatchException();
        } catch (InputMismatchException exception) {
            System.out.println("[!] Please provide a number between 1 and 6.");
        }
    }

    public String getHighestGrade() {
        var highest = grades.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).get();
        return highest.getValue() + " (" + highest.getKey() + ")";
    }

    public String getLowestGrade() {
        var lowest = grades.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();
        return lowest.getValue() + " (" + lowest.getKey() + ")";
    }

    public float getAverageGrade() {
        return grades.values().stream().reduce(0, Integer::sum) / (float) grades.size();
    }
}