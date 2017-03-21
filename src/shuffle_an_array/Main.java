package shuffle_an_array;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-20-下午1:15
 */

public class Main {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6};
        Solution2 solution = new Solution2(nums);
        nums = solution.shuffle();
        System.out.println(Arrays.toString(nums));
    }
}
