package random_pick_index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author yejinbiao
 * @create 2017-03-19-下午6:15
 */

public class Solution {
    private Map<Integer, ArrayList> table;
    private Random random;
    public Solution(int[] nums) {
        table = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = table.getOrDefault(nums[i], new ArrayList<Integer>());
            list.add(i);
            table.put(nums[i],list);
        }
    }

    public int pick(int target) {
        ArrayList<Integer> list = table.get(target);
        int size = list.size();
        if (size == 1) {
            return list.get(0);
        }else {
            int randomIndex = random.nextInt(size);
            return list.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,3,3};
        Solution solution = new Solution(nums);
        int index = solution.pick(3);
        System.out.print(index);
    }
}
