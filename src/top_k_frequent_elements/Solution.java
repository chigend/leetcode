package top_k_frequent_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-19-下午3:49
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,1,2,2,3};
        List<Integer> result = topKFrequent(nums,3);
        System.out.print(result);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> table = new HashMap<>();
        int maxFrequency = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = table.getOrDefault(num, 0);
            count++;
            maxFrequency = Math.max(count, maxFrequency);
            table.put(num, count);
        }
        ArrayList<Integer> [] array = new ArrayList[maxFrequency + 1];
        for (Integer i : table.keySet()) {
            int count = table.get(i);
            if (array[count] == null) {
                array[count] = new ArrayList<>();
            }
            array[count].add(i);
        }
        for (int i = array.length - 1; i >= 0 && k > 0; i--) {
            ArrayList<Integer> list = array[i];
            if (list != null) {
                for (int j = 0; j < list.size() && k > 0; j++ ) {
                    result.add(list.get(j));
                    k--;
                }
            }
        }
        return result;
    }
}
