import java.util.Random;
import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        startGame();
        SCANNER.close();
    }

    private static Choice getInputAsChoice() {
        try {
            String input = SCANNER.nextLine();
            return Choice.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("[!] This is not a valid choice. Please try again:");
            return getInputAsChoice();
        }
    }

    private static void startGame() {
        int randomInt = RANDOM.nextInt(3);
        Choice computerChoice = Choice.values()[randomInt];

        System.out.println("A new game has started!");
        System.out.println("-------------------------");
        System.out.println("\nPlease enter rock, paper or scissor:");

        Choice userChoice = getInputAsChoice();

        try {
            boolean computerIsWinner = computerIsWinner(computerChoice, userChoice);

            if (computerIsWinner) {
                System.out.println(String.format(
                        "The computer won with %s against %s.",
                        computerChoice.toString(),
                        userChoice.toString()));
            } else {
                System.out.println(String.format(
                        "The user won with %s against %s.",
                        userChoice.toString(),
                        computerChoice.toString()));
            }
        } catch (NoWinnerException exception) {
            System.out.println(exception.getMessage() + "\nTime for a rematch!\n");
            startGame();
        }
    }

    private static boolean computerIsWinner(Choice computerChoice, Choice userChoice) throws NoWinnerException {
        switch (computerChoice) {
            case ROCK:
                if (userChoice == Choice.ROCK) {
                    throw new NoWinnerException(Choice.ROCK);
                }

                return userChoice == Choice.SCISSOR;

            case PAPER:
                if (userChoice == Choice.PAPER) {
                    throw new NoWinnerException(Choice.PAPER);
                }

                return userChoice == Choice.ROCK;

            default: // SCISSOR
                if (userChoice == Choice.SCISSOR) {
                    throw new NoWinnerException(Choice.SCISSOR);
                }

                return userChoice == Choice.PAPER;
        }
    }
}