package largest_number_greater_than_twice_of_others;

public class Solution {
    public static void main(String[] args) {

    }

    public static int dominantIndex(int[] nums) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (i != index) {
                if (max < 2 * nums[i]) {
                    return -1;
                }
            }
        }
        return index;

    }
}
