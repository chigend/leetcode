package number_of_good_pairs;

public class Solution {

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{6, 5, 1, 5, 7, 7, 9, 1, 5, 7, 1, 6, 10, 9, 7, 4, 1, 8, 7, 1, 1, 8, 6, 4, 7, 4, 10, 5, 3, 9, 10, 1, 9, 5, 5, 4, 1, 7, 4, 2, 9, 2, 6, 6, 4, 2, 10, 3, 5, 3, 6, 4, 7, 4, 6, 4, 4, 6, 3, 4, 10, 1, 10, 6, 10, 4, 9, 6, 6, 4, 8, 6, 9, 5, 4}));
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num] += 1;
        }
        int total = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                total += factorial(count[i], 2) / 2;
            }
        }
        return total;
    }

    public static int factorial(int n, int m) {
        if (m == 0) {
            return 1;
        } else {
            return n * factorial(n - 1, m - 1);
        }
    }
}
