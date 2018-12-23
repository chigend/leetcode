package n_repeated_element_in_size_2n_array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = solution.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4});
        System.out.println(num);
    }

    public int repeatedNTimes(int[] A) {
        int[] count = new int[10000];
        for (int num : A) {
            if (count[num]++ == 1) {
                return num;
            }
        }
        return -1;
    }
}
