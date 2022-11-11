class Main {
    private static final int CELSIUS_FROM = 0;
    private static final int CELSIUS_TO = 20;

    public static void main(String[] args) {
        for (int celsius = CELSIUS_FROM; celsius <= CELSIUS_TO; celsius++) {
            double fahrenheit = convertCelsiusToFahrenheit(celsius);
            System.out.println(String.format("%s °C = %.2f °F", celsius, fahrenheit));
        }
    }

    private static double convertCelsiusToFahrenheit(int celsius) {
        return 9 / 5f * celsius + 32;
    }
}