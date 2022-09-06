package minimum_size_subarray_sum;

import tool.ArrayTestCaseTransformer;

/**
 * O(nln(b))   做一个前缀和 再使用遍历加二分查找
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minSubArrayLen(15, ArrayTestCaseTransformer.transform("[1,2,3,4,5]"));
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        if (sum[sum.length - 1] < target) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            int num = sum[i];
            int index = binarySearch(sum, i, sum.length - 1, target + num);
            min = Math.min(index - i, min);
        }
        return min > nums.length ? 0 : min;
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r] >= target ? r : Integer.MAX_VALUE;
    }
}