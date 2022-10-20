import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        try {
            System.out.println("Enter a word: ");
            String word = reader.next();

            System.out.println("Reverse: " + isPalindromeWithReverse(word));
            System.out.println("CharAt: " + isPalindromeWithCharAt(word));
            System.out.println("Char Array: " + isPalindromeWithCharArray(word));
        } catch (Exception exception) {
            System.out.println("Oh no. Something bad happened: " + exception.getMessage());
        } finally {
            reader.close();
        }
    }

    private static boolean isPalindromeWithReverse(String word) {
        String reversedWord = new StringBuilder(word).reverse().toString();
        return word.equals(reversedWord);
    }

    private static boolean isPalindromeWithCharAt(String word) {
        int wordLength = word.length();

        for (int i = 0; i < wordLength / 2; i++) {
            char front = word.charAt(i);
            char back = word.charAt(wordLength - 1 - i);

            if (front != back)
                return false;
        }

        return true;
    }

    private static boolean isPalindromeWithCharArray(String word) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char front = chars[i];
            char back = chars[chars.length - 1 - i];

            if (front != back)
                return false;
        }

        return true;
    }
}