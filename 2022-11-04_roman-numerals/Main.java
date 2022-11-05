import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please provide a number from 1 - 10:");

        int number = getInputAsIntegerInRange(1, 10);
        String romanNumeral = convertToRomanNumeral(number);

        System.out.println(String.format("%s as roman numeral is: %s", number, romanNumeral));

        SCANNER.close();
    }

    private static int getInputAsIntegerInRange(int min, int max) {
        try {
            int input = Integer.parseInt(SCANNER.nextLine());

            if (input < min || input > max) {
                throw new Exception();
            }

            return input;
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return getInputAsIntegerInRange(min, max);
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