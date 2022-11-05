import java.util.Map;
import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<Integer, Integer> CONVERSIONS = Map.of(
            0, 0,
            1, 5,
            2, 15,
            3, 30,
            4, 60);

    public static void main(String[] args) {
        System.out.println("Please state how many books you have purchased this month:");
        int amountBooks = getInputAsInteger();

        int points = getPointByAmountOfBooks(amountBooks);

        System.out.println(String.format("You have been awarded %s points.", points));

        SCANNER.close();
    }

    private static int getInputAsInteger() {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again: ");
            return getInputAsInteger();
        }
    }

    private static int getPointByAmountOfBooks(int amountBooks) {
        amountBooks = Math.max(0, amountBooks);
        amountBooks = Math.min(4, amountBooks);
        return CONVERSIONS.get(amountBooks);
    }
}