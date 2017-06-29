package longest_increasing_subsequence;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-06-29-14:45
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    public static int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
       int len = 0;
       for (int num : nums) {
           int i = Arrays.binarySearch(dp,0,len,num);
           if (i < 0) {
               i = -(i+1);
           }
           dp[i] = num;
           if (i == len) {
               len++;
           }
       }
       return len;
    }
}
