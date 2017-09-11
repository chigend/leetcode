package _4_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static List<List<Integer>> result;
    public static int[] candidates;

    public static void main(String[] args) {
        int[] candidates = new int[]{-3,-2,-1,0,0,1,2,3};
        List res = fourSum(candidates,0);
        System.out.println(res);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len - 3; i++) {
            if (nums[i] + nums[i+1]+nums[i+2]+nums[i+3] > target) {
                break;
            }
            if (nums[i] + nums[len-1]+nums[len-2]+nums[len-3] < target) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (nums[i] + nums[j]+nums[j+1]+nums[j+2] > target) {
                    break;
                }
                if (nums[i] + nums[j]+nums[len-1]+nums[len-2] < target) {
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = len - 1;
                while (start < end) {
                    if (start > j + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j],nums[start],nums[end]));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end+1]) {
                            end--;
                        }
                    }else if (sum < target) {
                        start++;
                    }else {
                        end--;
                    }
                }
            }
        }
        return result;
    }


}
