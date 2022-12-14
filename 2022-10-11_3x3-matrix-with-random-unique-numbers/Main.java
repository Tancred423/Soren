import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

class Main {
    private static final int MIN = 1;
    private static final int MAX = 30;
    private static final int MATRIX_SIZE = 3;

    public static void main(String[] args) {
        if (Math.sqrt(MAX) < MATRIX_SIZE) {
            System.out.println("[!] With the current settings it is impossible to generate enough unique numbers.");
            return;
        }

        var randomNumbers = getUniqueRandomNumbers((int) Math.pow(MATRIX_SIZE, 2));
        var matrix = buildMatrix(randomNumbers);

        System.out.println(matrix);
    }

    private static ArrayList<Integer> getUniqueRandomNumbers(Integer amount) {
        var randomNumbers = new ArrayList<Integer>();

        while (randomNumbers.size() < amount) {
            var randomNumber = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            if (!randomNumbers.contains(randomNumber)) randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }

    private static String buildMatrix(ArrayList<Integer> randomNumbers) {
        var stringBuilder = new StringBuilder();
        var counter = 0;

        for (Integer randomNumber : randomNumbers) {
            if (counter % MATRIX_SIZE == 0) stringBuilder.append("\n");
            if (randomNumber < 10) stringBuilder.append(" ");
            stringBuilder.append(randomNumber).append(" ");
            counter++;
        }

        return stringBuilder.toString();
    }
}