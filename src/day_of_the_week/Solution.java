package day_of_the_week;

import java.time.LocalDate;
import java.util.Locale;

import sun.util.resources.LocaleData;

public class Solution {

    public static void main(String[] args) {
        String s = dayOfTheWeek(15, 7, 1987);

        System.out.println(s);
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        int days = 0;

        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1970; i < year; i++) {
            if (isLeapYear(i)) {
                days += 366;
            } else {
                days += 365;
            }
        }
        if (isLeapYear(year) && month > 2) {
            days += 1;
        }

        for (int i = 1; i < month; i++) {
            days += daysOfMonth[i - 1];
        }
        days += day - 1;
        int mod = days % 7;
        String[] weekdays = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        return weekdays[mod];
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}
