package shuffle_an_array;

import java.util.Random;

/**
 * @author yejinbiao
 * @create 2017-03-20-下午1:40
 */

public class Solution2 {
    private int[] original;
    private Random random;

    public Solution2(int[] nums) {
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
        for (int i = 0; i < original.length; i++) {
            int j = random.nextInt(i+1);
            values[i] = values[j];
            values[j] = original[i];
        }
        return values;
    }


}
