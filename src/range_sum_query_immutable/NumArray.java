package range_sum_query_immutable;

public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        /**
         * sums[k] means the sum of the first k numbers
         *
         * so sum(i,j) can be replace with sums[j + 1] - sum[i] since the index is always one less than
         * length (下标比个数少1，第三个3数的下标是2)
         */
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}