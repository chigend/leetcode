package number_of_good_pairs;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2}));
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int total = 0;

        for (int num : nums) {
            total += count[num];
            count[num] += 1;
        }

        return total;
    }

}
