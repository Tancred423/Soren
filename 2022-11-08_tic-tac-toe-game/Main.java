import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String[][] board = new String[3][3];
    private static boolean isPlayerOnesTurn = true;
    private static boolean isTie = false;

    public static void main(String[] args) {
        initializeBoard();

        System.out.println("The Tic Tac Toe game begins!");
        System.out.println("Here is the game board:");

        printBoard();

        boolean isOver = false;

        while (!isOver) {
            isOver = playRoundUntilIsOver();
            printBoard();
        }

        if (isTie) {
            System.out.println("It's a tie!");
        } else {
            System.out.println(String.format("Player %s has won the game!", getPlayerName()));
        }

        SCANNER.close();
    }

    private static int getInputAsIntegerBetween1And3() {
        try {
            int input = Integer.parseInt(SCANNER.nextLine());

            if (input < 1 || input > 3) {
                throw new Exception();
            }

            return input - 1;
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return getInputAsIntegerBetween1And3();
        }
    }

    private static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                board[row][column] = "*";
            }
        }
    }

    private static void printBoard() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (column == 0) {
                    stringBuilder.append("\n");
                }

                stringBuilder.append(board[row][column]);
            }
        }

        stringBuilder.append("\n");

        System.out.println(stringBuilder.toString());
    }

    private static boolean playRoundUntilIsOver() {
        System.out.println(String.format("Player %s, please enter the ROW your want to place your %s on:",
                getPlayerName(), getPlayerSymbol()));
        int row = getInputAsIntegerBetween1And3();

        System.out.println(String.format("Player %s, please enter the COLUMN your want to place your %s on:",
                getPlayerName(), getPlayerSymbol()));
        int column = getInputAsIntegerBetween1And3();

        if (!isFreeCell(row, column)) {
            System.out.println("This cell is not free! Please choose another...");
            return playRoundUntilIsOver();
        }

        board[row][column] = getPlayerSymbol();

        if (hasWon() || isTie()) {
            return true;
        }

        isPlayerOnesTurn = !isPlayerOnesTurn;

        return false;
    }

    private static boolean isFreeCell(int row, int column) {
        return board[row][column].equals("*");
    }

    private static String getPlayerName() {
        return isPlayerOnesTurn ? "ONE" : "TWO";
    }

    private static String getPlayerSymbol() {
        return isPlayerOnesTurn ? "X" : "O";
    }

    private static boolean hasWon() {
        // Horizontal
        for (String[] row : board) {
            if (Arrays.asList(row).stream().allMatch(cell -> cell.equals(getPlayerSymbol()))) {
                return true;
            }
        }

        // Vertical
        for (int column = 0; column < 3; column++) {
            List<String> cellsAtColumn = Arrays.asList(board[0][column], board[1][column], board[2][column]);

            if (cellsAreEqualAndNotEmpty(cellsAtColumn)) {
                return true;
            }
        }

        // Diagonal
        List<String> cellsDiagonallyStartingTopLeft = Arrays.asList(board[0][0], board[1][1], board[2][2]);
        List<String> cellsDiagonallyStartingBottomLeft = Arrays.asList(board[2][0], board[1][1], board[0][2]);

        return cellsAreEqualAndNotEmpty(cellsDiagonallyStartingTopLeft)
                || cellsAreEqualAndNotEmpty(cellsDiagonallyStartingBottomLeft);
    }

    private static boolean cellsAreEqualAndNotEmpty(List<String> cells) {
        boolean anyCellIsEmpty = cells.stream().anyMatch(cell -> cell.equals("*"));
        boolean allCellsAreEqual = new HashSet<>(cells).size() == 1;

        return !anyCellIsEmpty && allCellsAreEqual;
    }

    private static boolean isTie() {
        for (String[] rows : board) {
            if (Arrays.asList(rows).stream().anyMatch(cell -> cell.equals("*"))) {
                return false;
            }
        }

        isTie = true;

        return true;
    }
}