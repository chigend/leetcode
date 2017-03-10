package relative_ranks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-09-下午5:57
 */

public class Solution {
    public static void main(String[] args) {

        int [] arr = new int[] {1,3345,2,3};

        String [] relativeRanks = findRelativeRanks(arr);
        System.out.println(Arrays.toString(relativeRanks));
    }

    public static String[] findRelativeRanks(int[] nums) {
        int [] temp  = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);
        Map<Integer, String> table = new HashMap<>();
        String [] prizes = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = temp.length - 1; i >= 0; i --) {
            int rank = temp.length - i;
            if (rank <= 3) {
                table.put(temp[i], prizes[rank - 1]);
            }else {
                table.put(temp[i], rank + "");
            }
        }
        String [] result = new String[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            result[i] = table.get(nums[i]);
        }
        return result;
    }


}
