import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a word:");
        String word = getInputAsString();

        boolean isPalindrome = isPalindrome(word);

        if (isPalindrome) {
            System.out.println(String.format("%s is a palindrome.", word));
        } else {
            System.out.println(String.format("%s is not a palindrome.", word));
        }

        SCANNER.close();
    }

    private static String getInputAsString() {
        return SCANNER.nextLine();
    }

    private static boolean isPalindrome(String word) {
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