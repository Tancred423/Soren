import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int ROUNDS = 10;

    public static void main(String[] args) {
        int amountColors = Color.values().length;
        int amountMatches = 0;

        for (int i = 0; i < ROUNDS; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(amountColors - 1);
            Color computerColor = Color.values()[randomIndex];

            System.out.println(
                    String.format("ROUND %s | Please pick a color from red, green, blue, orange, yellow:", i + 1));
            Color userColor = getInputAsColor();

            if (computerColor == userColor) {
                System.out.println(String.format("Both of you picked %s.", computerColor));
                amountMatches++;
            } else {
                System.out.println(String.format("The computer picked %s instead.", computerColor));
            }
        }

        double percent = (double) amountMatches / ROUNDS * 100;

        System.out.println(String.format(
                "You picked the correct color %s out of %s times (%.0f %%).",
                amountMatches,
                ROUNDS,
                percent));

        SCANNER.close();
    }

    private static Color getInputAsColor() {
        try {
            String guess = SCANNER.nextLine();
            return Color.valueOf(guess.toUpperCase());
        } catch (Exception e) {
            System.out.println("[!] This is not a valid color. Try again:");
            return getInputAsColor();
        }
    }
}