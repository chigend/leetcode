package majority_element;

/**
 * moore voting solution
 */
public class Solution3 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,1,2,3,4,1,5,6,7,1,1,1};
        int major = majorityElement(nums);
        System.out.print(major);
    }
    public static int majorityElement(int[]nums){
        //由于出现次数大于n/2的数只有一个，所以该数出现的频率与所有其他数的频率差大于0
        int majorIndex = -1;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                majorIndex = i;
            }
            if(nums[i] == nums[majorIndex]){
                count++;
            }else {
                count--;
            }
        }
        return nums[majorIndex];
    }
}
