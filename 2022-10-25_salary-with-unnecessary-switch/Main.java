import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        double salary = getSalaryInput();
        int percentage = getPercentage(salary);
        double increasedSalary = increaseSalary(salary, percentage);

        System.out.printf("The salary is now $%.2f\n", increasedSalary);
    }

    private static double getSalaryInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Please state your salary: ");
            return scanner.nextDouble();
        } catch (InputMismatchException exception) {
            System.out.println("[!] Error: Invalid salary input. Please try again.");
            return getSalaryInput();
        } finally {
            scanner.close();
        }
    }

    private static int getPercentage(double salary) {
        if (salary >= 0 && salary < 9000)
            return 20;
        else if (salary >= 9000 && salary < 15000)
            return 10;
        else if (salary >= 15000 && salary < 20000)
            return 5;
        else
            return 3;
    }

    private static double increaseSalary(double salary, int percentage) {
        switch (percentage) {
            case 20:
                return salary * 1.2;
            case 10:
                return salary * 1.1;
            case 5:
                return salary * 1.05;
            default: // 3
                return salary * 1.03;
        }
    }
}
