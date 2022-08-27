package angle_between_hands_of_a_clock;

public class Solution {

    public static void main(String[] args) {

    }

    public double angleClock(int hour, int minutes) {
        hour %= 12;
        double x = hour * 30 + minutes * 0.5;
        double y = minutes * 6;
        double diff = Math.abs(x - y);
        return Math.min(diff, 360 - diff);
    }
}
