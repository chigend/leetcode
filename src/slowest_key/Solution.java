package slowest_key;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        char cbcd = slowestKey(ArrayTestCaseTransformer.transform("[12,23,36,46,62]"), "spuda");
        System.out.println(cbcd);
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = 0;
        int last = 0;
        char slowest = 'a' - 1;
        char[] chs = keysPressed.toCharArray();
        for (int i = 0; i < releaseTimes.length; i++) {
            int time = releaseTimes[i];
            if (time - last > maxTime) {
                maxTime = time - last;
                slowest = chs[i];
            } else if (time - last == maxTime) {
                slowest = chs[i] > slowest ? chs[i] : slowest;
            }

            last = time;
        }
        return slowest;
    }
}
