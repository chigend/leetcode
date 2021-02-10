package perform_string_shifts;

public class Solution {

    public static void main(String[] args) {

    }

    public String stringShift(String s, int[][] shift) {
        int shifts = 0;
        for (int[] nums : shift) {
            if (nums[0] == 0) {
                shifts -= nums[1];
            } else {
                shifts += nums[1];
            }
        }

        shifts %= s.length();
        if (shifts > 0) {
            return s.substring(s.length() - shifts) + s.substring(0, s.length() - shifts);
        } else {
            return s.substring(-shifts) + s.substring(0, -shifts);
        }
    }
}
