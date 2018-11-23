package binary_watch;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<String> result = solution2.readBinaryWatch(3);
        System.out.println(result);

    }

    public  List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < (1 << 10); i++) {
            int minute = i & 0x3F;
            int hour = (i >> 6) & 0xF;
            if (minute <= 59 && hour <= 11 && Integer.bitCount(minute) + Integer.bitCount(hour) == num) {
                result.add(hour + ":" + (minute < 10 ? "0" : "") + minute);
            }
        }
        return result;
    }
}
