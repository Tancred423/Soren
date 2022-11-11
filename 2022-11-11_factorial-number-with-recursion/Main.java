import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter an absolute number between 0 - 20:");

        int number = getInputAsIntegerBetween0and20();
        long factorial = getFactorialOfNumber(number);

        System.out.println(String.format("The factorial of %s is %s.", number, factorial));

        SCANNER.close();
    }

    private static int getInputAsIntegerBetween0and20() {
        try {
            int input = Integer.parseInt(SCANNER.nextLine());

            if (input < 0 || input > 20) {
                throw new Exception();
            }

            return input;
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return getInputAsIntegerBetween0and20();
        }
    }

    private static long getFactorialOfNumber(long number) {
        if (number - 1 <= 0) {
            return number;
        }

        return number * getFactorialOfNumber(number - 1);
    }
}