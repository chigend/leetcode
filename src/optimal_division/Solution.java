package optimal_division;

public class Solution {
    public static void main(String[] args) {

    }

    //to get the maximum result, we should get minimum result of the elements after fist element
    //so the minimun result of the elements after first element will be the result of division of
    //all the element after first element in order.
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums.length < 3) {
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i]).append("/");
            }
            return sb.deleteCharAt(sb.length()-1).toString();
        }
        sb.append(nums[0]).append("/").append("(");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]).append("/");
        }
        sb.deleteCharAt(sb.length()-1).append(")");
        return sb.toString();
    }
}
