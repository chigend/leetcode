package find_the_highest_altitude;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int[] transform = ArrayTestCaseTransformer.transform("[-4,-3,-2,-1,4,3,2]");
        int i = largestAltitude(transform);
        System.out.println(i);
    }

    public static int largestAltitude(int[] gain) {

        int maxAltitude = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            gain[i] += sum;
            sum = gain[i];
            maxAltitude = Math.max(sum, maxAltitude);
        }
        return maxAltitude;
    }
}
