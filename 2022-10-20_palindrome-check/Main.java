import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        try {
            System.out.println("Enter a word: ");
            String word = reader.next();

            System.out.println(isPalindrome(word));
            System.out.println(isPalindromeWithLoops(word));
        } catch (Exception exception) {
            System.out.println("Oh no. Something bad happened: " + exception.getMessage());
        } finally {
            reader.close();
        }
    }

    private static boolean isPalindrome(String word) {
        var reversedWord = new StringBuilder(word).reverse().toString();
        return word.equals(reversedWord);
    }

    private static boolean isPalindromeWithLoops(String word) {
        int wordLength = word.length();

        for (int i = 0; i < wordLength / 2; i++) {
            char front = word.charAt(i);
            char back = word.charAt(wordLength - 1 - i);

            if (front != back)
                return false;
        }

        return true;
    }
}