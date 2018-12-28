package total_hamming_distance;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int totalHammingDistance = solution.totalHammingDistance(new int[]{4,14,2});
        System.out.println(totalHammingDistance);
    }

    /**
     * 自己的算法
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++ ) {
                distance += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return distance;
    }

    /**
     * idea :https://leetcode.com/problems/total-hamming-distance/discuss/96243/Share-my-O(n)-C++-bitwise-solution-with-thinking-process-and-explanation
     * @param nums
     * @return
     */
    public int totalHammingDistance2(int[] nums) {
        int distance = 0;
        for(int i = 0; i < 32; i++) {
            int bitSet = 0;
            for (int j = 0; j < nums.length; j++) {
                bitSet += (nums[j] >> i) & 1;
            }
            distance += bitSet * (nums.length - bitSet);
        }
        return distance;
    }


}
