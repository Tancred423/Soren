import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws ParseException {
        String input = getInput();
        Calendar calendar = getCalendarFromInput(input);
        int dayOfYear = getDayOfYear(calendar);

        System.out.println("The day of the year is: " + dayOfYear);
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
        if (year % 1000 == 0)
            return true;

        // If the last 2 digits of a year is dividable by 4, it is a leap year.
        // E.g. 1904, 1908... or 2004, 2008...
        else if ((year % 100) % 4 == 0)
            return true;

        return false;
    }

    // Alternative getNumberOfDaysInMonth() without switch. Fancier, but I guess I
    // have to use a switch statement... Therefore not used at the moment.
    private static int getNumberOfDaysInMonth2(int month, boolean isLeapYear) {
        if (month % 2 == 0) {
            if (month == 2 && isLeapYear)
                return 29;
            else if (month == 2)
                return 28;

            return 30;
        }

        return 31;
    }

    ////////////////////////////////////////
    // Uninteresting part.
    // Just getting the input and converting it to a Calendar object.
    ////////////////////////////////////////

    private static String getInput() {
        var scanner = new Scanner(System.in);
        var pattern = "\\d{4}-\\d{2}-\\d{2}";

        try {
            System.out.print("Please provide a date (YYYY-MM-DD): ");
            return scanner.next(pattern);
        } catch (InputMismatchException exception) {
            System.out.println("[!] Error: Wrong format. Please use YYYY-MM-DD.");
            return getInput();
        } finally {
            scanner.close();
        }
    }

    private static Calendar getCalendarFromInput(String input) throws ParseException {
        var date = new SimpleDateFormat("yyyy-MM-dd").parse(input);
        var calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }
}
