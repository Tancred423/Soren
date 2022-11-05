import java.util.List;

class Main {
    private static final double BURNED_CALORIES_PER_MINUTE = 3.9;
    private static final List<Integer> MINUTES = List.of(10, 15, 25, 30);

    public static void main(String[] args) {
        for (int minute : MINUTES) {
            double burnedCalories = calculateBurnedCalories(minute);
            System.out.println(
                    String.format("After %s minutes you'd have burned %s calories.", minute, burnedCalories));
        }
    }

    private static double calculateBurnedCalories(int minutes) {
        return minutes * BURNED_CALORIES_PER_MINUTE;
    }
}