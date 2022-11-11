import java.util.ArrayList;
import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter your budget for this month:");
        double budget = convertStringToDouble(getInputAsString());

        System.out.println("Please enter your expenses one at the time and type 'fin' when you are done:");
        ArrayList<Double> expenses = getExpenses();

        double sumOfExpenses = expenses.stream().mapToDouble(Double::doubleValue).sum();

        if (sumOfExpenses > budget) {
            System.out.println(String.format("You are %.2f euro over your budget.", sumOfExpenses - budget));
        } else {
            System.out.println(String.format("You are %.2f euro under your budget.", budget - sumOfExpenses));
        }

        SCANNER.close();
    }

    private static String getInputAsString() {
        try {
            return SCANNER.nextLine();
        } catch (Exception e) {
            System.out.println("[!] Something went wrong. Try again:");
            return getInputAsString();
        }
    }

    private static double convertStringToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return convertStringToDouble(getInputAsString());
        }
    }

    private static ArrayList<Double> getExpenses() {
        ArrayList<Double> expenses = new ArrayList<>();

        while (true) {
            String input = getInputAsString();

            if (input.equalsIgnoreCase("fin")) {
                break;
            }

            expenses.add(convertStringToDouble(input));
        }

        return expenses;
    }
}