package next_greater_element_III;

/**
 * @author yejinbiao
 * @create 2017-05-06-10:51
 */

public class Solution {
    public static void main(String[] args) {
        int result = nextGreaterElement(1999999999);
        System.out.print(result);
    }


    public static int nextGreaterElement(int n) {
        int length = String.valueOf(n).length();
        int [] nums = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            nums[i] = n % 10;
            n /= 10;
        }
        int low = 0;
        int high = length - 1;
        boolean isLargest = true;
        for (int i = length - 1; i > 0;i--) {
            if (nums[i] > nums[i - 1]) {
                int leastLarger = length - 1;
                while (nums[leastLarger] <= nums[i-1]) leastLarger--;
                swap(i-1,leastLarger,nums);
                low = i;
                isLargest = false;
                break;
            }
        }
        if (isLargest) return -1;
        while (low < high){
            swap(low,high,nums);
            low++;
            high--;
        }
        long result = 0;
        for (int i = 0; i < length;i++){
            result *= 10;
            result += nums[i];
        }
        return result > Integer.MAX_VALUE ? -1 : (int)result;

    }

    public static void swap(int i,int j,int[]nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
