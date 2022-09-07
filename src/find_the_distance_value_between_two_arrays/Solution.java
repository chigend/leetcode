package find_the_distance_value_between_two_arrays;

import java.util.Arrays;

import tool.ArrayTestCaseTransformer;

public class Solution {


    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            res += binarySearch(arr2, arr1[i] - d, arr1[i] + d);
        }
        return res;
    }

    public int binarySearch(int[] nums, int low, int high) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= high) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int end = r;
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= low) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r < end || r == end && nums[r] >= low && nums[r] <= high ? 0 : 1;
    }
}
