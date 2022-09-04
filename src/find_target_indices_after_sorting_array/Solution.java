package find_target_indices_after_sorting_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);


        int l = 0;

        int r = nums.length - 1;



        while(l < r) {
            int mid = (l + r) >> 1;
            if(nums[mid] >= target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if (nums[r] != target) {
            return new ArrayList<>();
        }
        int low = r;


        l = 0;
        r = nums.length - 1;
        while(l < r) {
            int mid = (l + r + 1) >> 1;
            if(nums[mid] <= target) {
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = low; i <= r; i++) {
            res.add(i);
        }

        return res;

    }
}
