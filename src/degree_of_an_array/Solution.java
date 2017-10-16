package degree_of_an_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        int len = findShortestSubArray(nums);
        System.out.println(len);
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexes = hashMap.getOrDefault(nums[i], new ArrayList<>());
            indexes.add(i);
            hashMap.put(nums[i], indexes);
        }
        int maxCount = 0;
        int minLen = 0;
        for (List<Integer> indexes : hashMap.values()) {
            if (indexes.size() > maxCount) {
                maxCount = indexes.size();
                minLen = indexes.get(indexes.size() - 1) - indexes.get(0) + 1;
            }else if (indexes.size() == maxCount) {
                minLen = Math.min(indexes.get(indexes.size() - 1) - indexes.get(0) + 1, minLen);
            }
        }
        return minLen;
    }
}
