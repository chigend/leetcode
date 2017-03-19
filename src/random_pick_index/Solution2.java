package random_pick_index;

import java.util.Random;

/**
 * @author yejinbiao
 * @create 2017-03-19-下午6:31
 */

public class Solution2 {
    private int [] nums;
    private Random random = new Random();
    public Solution2(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int index = -1;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                size++;
                index = random.nextInt(size) == 0 ? i : index;
            }
        }
        return index;
    }
}
