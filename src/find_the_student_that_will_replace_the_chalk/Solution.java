package find_the_student_that_will_replace_the_chalk;

import tool.ArrayTestCaseTransformer;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.chalkReplacer(ArrayTestCaseTransformer.transform("[3,4,1,2]"), 25));
    }

    public int chalkReplacer(int[] chalk, int k) {
        long[] sums = new long[chalk.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + chalk[i - 1];
        }
        long sum = sums[chalk.length];

        k = (int) (k % sum);

        int l = 0;
        int r = sums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (sums[mid] > k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r - 1;

    }
}
