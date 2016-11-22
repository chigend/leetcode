package remove_duplicates_from_sorted_array;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {

	}

	public int removeDuplicates(int[] nums) {
		if(nums.length == 0 || nums.length == 1){
			return nums.length;
		}
			int newLength = 0;
			int presentNum = nums[0]; //定义当前有可能重复的数字,初始为数组的第一个数
			boolean [] saved = new boolean[nums.length];
			for(int i=1;i<nums.length;i++){
				if(nums[i] != presentNum){
					saved[i] = true;
					presentNum = nums[i];
				}
			}
			for(int i=0;i<saved.length;i++){
				if(saved[i]){
					nums[newLength++] = nums[i];
				}
			}
			return newLength;
	}
}
