import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var endNumber = getInput();
        var primeNumbers = new ArrayList<Integer>();

        for (int i = 2; i <= endNumber; i++)
            if (isPrime(i))
                primeNumbers.add(i);

        System.out.println("Prime numbers up to " + endNumber + " are: " + primeNumbers);
    }

    private static int getInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Get prime numbers up to number: ");

        var endNumber = 0;

        try {
            endNumber = reader.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("[!] Error: Please provide a valid number!");
            endNumber = getInput();
        } finally {
            reader.close();
        }

        return endNumber;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}