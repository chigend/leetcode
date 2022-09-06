package find_peak_element;

public class Solution2 {

    public static void main(String[] args) {

    }


    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = l + r >> 1;
            if(mid == nums.length - 1 || nums[mid] > nums[mid + 1]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return  r;
    }
}
