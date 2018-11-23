package binary_watch;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public static void main(String[] args) {

    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++ ) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
                    result.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
                }
            }
        }
        return result;
    }
}
