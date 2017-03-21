package shuffle_an_array;

import java.util.Random;

/**
 * @author yejinbiao
 * @create 2017-03-20-下午1:08
 */
public class Solution {

    private int[] original;
    private Random random;

    public Solution(int[] nums) {
        random = new Random();
        original = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int [] values = new int[original.length];
        System.arraycopy(original,0,values,0,original.length);
        for (int i = values.length - 1; i >= 0; i--) {
            int j = random.nextInt(i+1);
            swap(values, i, j);
        }
        return values;
    }

    private void swap(int [] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}