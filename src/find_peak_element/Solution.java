package find_peak_element;

/**
 * linear solution
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int peakIndex = solution.findPeakElement(new int[]{1,2,1,3,5,6,4});
        System.out.println(peakIndex);
    }

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ((i == 0 || nums[i] > nums[i - 1]) && (i == nums.length - 1 || nums[i] > nums[i + 1])){
                return i;
            }
        }
        return -1;
    }
}
