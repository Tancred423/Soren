public class NoWinnerException extends Exception {
    public NoWinnerException(Choice bothChoices) {
        super(String.format("It's a tie: %s against %s!", bothChoices, bothChoices));
    }
}
