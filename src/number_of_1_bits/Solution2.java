package number_of_1_bits;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int hammingWeight = solution2.hammingWeight(0);
        System.out.println(hammingWeight);
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}
