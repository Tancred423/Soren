import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        System.out.println("Please provide a date (YYYY-MM-DD):");
        String dateString = getInputAsString();

        Calendar calendar = getCalendarFromDateString(dateString);
        int dayOfYear = getDayOfYear(calendar);

        System.out.println(String.format("The day of the year is: %s", dayOfYear));

        SCANNER.close();
    }

    private static String getInputAsString() {
        String pattern = "\\d{4}-\\d{2}-\\d{2}";

        try {
            return SCANNER.next(pattern);
        } catch (InputMismatchException exception) {
            System.out.println("[!] Error: Wrong format. Please use YYYY-MM-DD.");
            return getInputAsString();
        }
    }

    private static Calendar getCalendarFromDateString(String input) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(input);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    private static int getDayOfYear(Calendar calendar) {
        // January is 0, but I wanna count from 1.
        int month = calendar.get(Calendar.MONTH) + 1;

        // I need this to check for leap years.
        int year = calendar.get(Calendar.YEAR);

        // Getting 28, 29, 30 or 31 for each prior month.
        int daysOfPriorMonths = getDaysOfPriorMonths(month, year);

        // The day of the current month.
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Sum days of prior months + day of current month.
        return daysOfPriorMonths + dayOfMonth;
    }

    private static int getDaysOfPriorMonths(int month, int year) {
        int days = 0;

        // Here I loop from 1 to the latest month (excluding the current month)
        // and sum up the days the months have. Also respecting leap years.
        for (int i = 1; i < month; i++)
            days += getNumberOfDaysInMonth(i, isLeapYear(year));

        return days;
    }

    private static int getNumberOfDaysInMonth(int month, boolean isLeapYear) {
        // Even months = 30 (with february exception)
        // Odd months = 31
        switch (month) {
            case 2:
                if (isLeapYear)
                    return 29;

                return 28;

            case 4:
            case 6:
            case 8:
            case 10:
            case 12:
                return 30;

            default: // 1, 3, 5, 7, 9, 11
                return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        // If the year is dividable by 1000, it is a leap year.
        // E.g. 1000 or 2000
        // OR if the last 2 digits of a year is dividable by 4, it is a leap year.
        // E.g. 1904, 1908... or 2004, 2008...
        return year % 1000 == 0 || (year % 100) % 4 == 0;
    }
}
