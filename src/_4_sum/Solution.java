package _4_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] candidates = new int[]{-489,-487,-471,-464,-451,-421,-414,-405,-396,-355,-354,-350,-336,-335,-334,-307,-298,-296,-295,-287,-267,-256,-247,-231,-170,-130,-120,-109,-96,-80,-78,-71,-63,-56,-44,-43,-13,2,9,18,31,36,39,43,49,49,50,61,68,73,99,107,112,113,120,121,173,180,185,190,203,210,233,246,258,296,319,340,345,370,371,378,395,418,436,444,447,451,460,485};
        List res = fourSum(candidates,2926);
        System.out.println(res);
    }

    public  static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int[] temp = new int[4];
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            temp[0] = nums[i];
            for (int j = i+1; j < nums.length-2;j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                temp[1] = nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (start > j + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum < target) {
                        start++;
                    }else if (sum > target) {
                        end--;
                    }else {
                        temp[2] = nums[start];
                        temp[3] = nums[end];
                        List <Integer>list = new ArrayList<>();
                        list.add(temp[0]);
                        list.add(temp[1]);
                        list.add(temp[2]);
                        list.add(temp[3]);
                        result.add(list);
                        start++;
                        end--;
                    }
                }

            }
        }
        return result;
    }
}
