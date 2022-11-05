import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int PROFIT_PERCENTAGE = 23;

    public static void main(String[] args) {
        System.out.println("Please provide the projected amount of total sales:");

        int totalSales = getInputAsInteger();
        int annualProfit = getAnnualProfit(totalSales);

        System.out.println(String.format("The annual profit is: %s", annualProfit));
        SCANNER.close();
    }

    private static int getInputAsInteger() {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return getInputAsInteger();
        }
    }

    private static int getAnnualProfit(int totalSales) {
        return Math.round(totalSales * PROFIT_PERCENTAGE / 100.0f);
    }
}