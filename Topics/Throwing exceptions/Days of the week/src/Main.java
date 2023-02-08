import java.util.*;

public class Main {

    enum DaysOfWeek {
        MON(1, "Mon"),
        TUE(2, "Tue"),
        WED(3, "Wed"),
        THU(4, "Thu"),
        FRI(5, "Fri"),
        SAT(6, "Sat"),
        SUN(7, "Sun");

        int dayNum;
        String dayName;

        DaysOfWeek(int dayNum, String dayName) {
            this.dayNum = dayNum;
            this.dayName = dayName;
        }

    }

    public static String getDayOfWeekName(int number) {

        for (DaysOfWeek day : DaysOfWeek.values()) {
            if (number == day.dayNum) {
                return day.dayName;
            }
        }
        throw new IllegalArgumentException();

        /*
        String dayOfWeekName = "";
        switch (number) {
            case 1 -> dayOfWeekName = "Mon";
            case 2 -> dayOfWeekName = "Tue";
            case 3 -> dayOfWeekName = "Wed";
            case 4 -> dayOfWeekName = "Thu";
            case 5 -> dayOfWeekName = "Fri";
            case 6 -> dayOfWeekName = "Sat";
            case 7 -> dayOfWeekName = "Sun";
            default -> throw new IllegalArgumentException();
        }
        return dayOfWeekName;
        */
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        try {
            System.out.println(getDayOfWeekName(dayNumber));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}