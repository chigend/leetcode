package xor_queries_of_a_subarray;

import tool.ArrayPrinter;
import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int[] ints = xorQueries(ArrayTestCaseTransformer.transform("[1,3,4,8]"), new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        ArrayPrinter.print(ints);
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        //dp[i] 代表 从 arr[0] xor 到 arr[i-1]的值
        int[] dp = new int[arr.length+1];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] ^ arr[i-1];
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] range = queries[i];
            res[i] = dp[range[1]+1] ^ dp[range[0]];
        }

        return res;
    }
}
