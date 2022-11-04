import java.util.Scanner;

class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please provide a number from 1 - 10:");

        int number = getInputAsInteger();
        String romanNumeral = convertToRomanNumeral(number);

        System.out.println(number + " as roman numeral is: " + romanNumeral);

        scanner.close();
    }

    private static int getInputAsInteger() {
        try {
            int input = Integer.parseInt(scanner.nextLine());

            if (input < 1 || input > 10) {
                throw new Exception();
            }

            return input;
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return getInputAsInteger();
        }
    }

    private static String convertToRomanNumeral(int number) {
        switch (number) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            default: // 10
                return "X";
        }
    }
}