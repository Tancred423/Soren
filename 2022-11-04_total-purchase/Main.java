import java.util.ArrayList;
import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int AMOUNT_OF_PURCHASES = 5;
    private static final int TAX_PERCENTAGE = 6;

    public static void main(String[] args) {
        ArrayList<Double> prices = new ArrayList<>();

        for (int i = 0; i < AMOUNT_OF_PURCHASES; i++) {
            System.out.println(String.format("Please enter the price of your %s. item:", i + 1));
            prices.add(getInputAsDouble());
        }

        double subtotal = calculateSubtotal(prices);
        double salesTax = calculateSalesTax(subtotal);
        double total = calculateTotal(subtotal, salesTax);

        System.out.println(String.format("Subtotal: %.2f | Sales tax: %.2f | Total: %.2f", subtotal, salesTax, total));
        SCANNER.close();
    }

    private static double getInputAsDouble() {
        try {
            return Double.parseDouble(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return getInputAsDouble();
        }
    }

    private static double calculateSubtotal(ArrayList<Double> prices) {
        return prices.stream().mapToDouble(Double::doubleValue).sum();
    }

    private static double calculateSalesTax(double subtotal) {
        return subtotal * TAX_PERCENTAGE / 100;
    }

    private static double calculateTotal(double subtotal, double salesTax) {
        return subtotal + salesTax;
    }
}