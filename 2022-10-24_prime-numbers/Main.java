import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a two-digit number: ");
        int number = getInputAsIntegerInRange(10, 99);

        String numberString = String.valueOf(number);
        int firstDigit = Integer.parseInt("" + numberString.charAt(0));
        int secondDigit = Integer.parseInt("" + numberString.charAt(1));

        boolean firstDigitIsPrimeNumber = isPrime(firstDigit);
        boolean secondDigitIsPrimeNumber = isPrime(secondDigit);

        if (firstDigitIsPrimeNumber) {
            System.out.println(String.format("%s is a prime number.", firstDigit));
        } else {
            System.out.println(String.format("%s is not a prime number.", firstDigit));
        }

        if (secondDigitIsPrimeNumber) {
            System.out.println(String.format("%s is a prime number.", secondDigit));
        } else {
            System.out.println(String.format("%s is not a prime number.", secondDigit));
        }

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

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}