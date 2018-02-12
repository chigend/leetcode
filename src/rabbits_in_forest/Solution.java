package rabbits_in_forest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {};
        int total = numRabbits(nums);
        System.out.println(total);
    }

    public static int numRabbits(int[] answers) {
        int total = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : answers) {
            if (num == 0) {
                total += 1;
            } else if (count.containsKey(num)) {
                if (num < count.get(num)) {
                    count.remove(num);
                    total += 1 + num;
                }
                count.put(num, count.get(num) + 1);
            }else {
                total += 1 + num;
                count.put(num, 1);
            }
        }
        return total;
    }
}
