package smallest_range_i;

public class Solution {

    public static void main(String[] args) {
        int i = smallestRangeI(new int[]{}, 3);
        System.out.println(i);
    }

    public static int smallestRangeI(int[] nums, int k) {
        int min = 10001;
        int max = -1;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int diff = max - min;
        return Math.max(0, diff - 2 * k);
    }
}
