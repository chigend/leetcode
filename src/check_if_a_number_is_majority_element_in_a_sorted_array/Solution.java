package check_if_a_number_is_majority_element_in_a_sorted_array;

public class Solution {

    public static void main(String[] args) {

    }

    public boolean isMajorityElement(int[] nums, int target) {
        int vote = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                vote++;
            } else {
                vote--;
            }
        }
        return vote > 0;
    }
}
