package number_of_days_between_two_dates;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int days1 = dayTo1970(date1);
        int days2 = dayTo1970(date2);
        return Math.abs(days1 - days2);
    }

    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public int dayTo1970(String date) {
        String[] ds1 = date.split("-");
        int y = Integer.parseInt(ds1[0]);
        int m = Integer.parseInt(ds1[1]);
        int d = Integer.parseInt(ds1[2]);
        int days = 0;
        for (int year = 1970; year < y; year++) {
            days += isLeapYear(year) ? 366 : 365;
        }
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(y)) {
            months[2] += 1;
        }
        for (int month = 1; month < m; month++) {
            days += months[month];
        }
        days += d;
        return days;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.daysBetweenDates("2020-01-15", "2019-12-31");
        //        int i = solution.daysBetweenDates("1971-01-15", "1972-03-01");
        System.out.println(i);
    }

}