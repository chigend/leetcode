package jump_game;

/**
 * @author yejinbiao
 * @create 2017-07-01-20:29
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
