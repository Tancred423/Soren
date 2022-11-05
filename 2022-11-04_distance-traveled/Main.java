import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Integer> TIMES_IN_HOURS = Arrays.asList(5, 8, 12);

    public static void main(String[] args) {
        System.out.println("Please provide the speed of the car in mph:");

        int speed = getInputAsInteger();

        for (Integer time : TIMES_IN_HOURS) {
            int distance = calculateDistanceInMiles(speed, time);

            System.out.println(String.format("The car traveled %s miles in %s hours.", distance, time));
        }

        SCANNER.close();
    }

    private static int getInputAsInteger() {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println("[!] This is not a valid number. Try again:");
            return getInputAsInteger();
        }
    }

    private static int calculateDistanceInMiles(int speed, int time) {
        return speed * time;
    }
}