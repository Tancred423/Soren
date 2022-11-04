import java.util.Scanner;

class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static int profitPercentage = 23;

    public static void main(String[] args) {
        System.out.println("Please provide the projected amount of total sales:");

        int totalSales = getInputAsInteger();
        int annualProfit = getAnnualProfit(totalSales);

        System.out.println("The annual profit is: " + annualProfit);
        scanner.close();
    }

    private static int getInputAsInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return getInputAsInteger();
        }
    }

    private static int getAnnualProfit(int totalSales) {
        return Math.round(totalSales * profitPercentage / 100);
    }
}