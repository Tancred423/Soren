import java.util.ArrayList;
import java.util.Scanner;

class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static int amountOfPurchases = 5;
    private final static int taxPercentage = 6;

    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>();

        for (int i = 0; i < amountOfPurchases; i++) {
            System.out.println("Please enter the price of your " + (i + 1) + ". item:");
            prices.add(getInputAsInteger());
        }

        int subtotal = calculateSubtotal(prices);
        int salesTax = calculateSalesTax(subtotal);
        int total = calculateTotal(subtotal, salesTax);

        System.out.println("Subtotal: " + subtotal + " | Sales tax: " + salesTax + " | Total: " + total);
    }

    private static int getInputAsInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again: ");
            return getInputAsInteger();
        }
    }

    private static int calculateSubtotal(ArrayList<Integer> prices) {
        return prices.stream().mapToInt(Integer::intValue).sum();
    }

    private static int calculateSalesTax(int subtotal) {
        return subtotal * taxPercentage / 100;
    }

    private static int calculateTotal(int subtotal, int salesTax) {
        return subtotal + salesTax;
    }
}