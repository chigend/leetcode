package number_of_1_bits;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int hammingWeight = solution.hammingWeight(-1);
        System.out.println(hammingWeight);
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
