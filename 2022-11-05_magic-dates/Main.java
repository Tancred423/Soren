import java.util.Scanner;

class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please provide a month in numeric form (1-12):");
        int month = getInputAsIntegerInRange(1, 12);

        System.out.println("Please provide a day in numeric form (1-31):");
        int day = getInputAsIntegerInRange(1, 31);

        System.out.println("Please provide a year (1000-9999):");
        int year = getInputAsIntegerInRange(1000, 9999);

        boolean isMagicDate = isMagicDate(month, day, year);

        if (isMagicDate) {
            System.out.println(String.format("%s/%s/%s is a magic date", month, day, year));
        } else {
            System.out.println(String.format("%s/%s/%s is not a magic date", month, day, year));
        }

        scanner.close();
    }

    private static int getInputAsIntegerInRange(int min, int max) {
        try {
            int input = Integer.parseInt(scanner.nextLine());

            if (input < min || input > max) {
                throw new Exception();
            }

            return input;
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return getInputAsIntegerInRange(min, max);
        }
    }

    private static boolean isMagicDate(int month, int day, int year) {
        int lastTwoDigitsOfYear = year % 100;
        return month * day == lastTwoDigitsOfYear;
    }
}