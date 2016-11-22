package two_sum;

import java.util.Arrays;
// two pointers solution   

public class Solution2 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
		
	}

	public static  int[] twoSum(int[] nums, int target) {
			int [] indexs = new int[2];
			int [] copy = new int[nums.length];
			System.arraycopy(nums, 0, copy, 0, nums.length);
			Arrays.sort(copy);
			int i = 0,j = nums.length - 1;
			while(i < j){
				int sum = copy[i] + copy[j];
				if(sum == target){
					indexs[0] = copy[i];
					indexs[1] = copy[j];
					break;
				}else if(sum < target){
					i++;
				}else{
					j--;
				}
			}
			int index1 = -1;
			int index2= -1;
			for(int k = 0;k< nums.length;k++){
				if(nums[k] == indexs[0] && index1 == -1){
					index1 = k;
				}else if(nums[k] == indexs[1] && index2 == -1){
					index2 = k;
				}
			}
			indexs[0] = index1;
			indexs[1] = index2;
			return indexs;
	}
	
	public static int findIndex(int targetNum,int [] nums){
		for(int i = 0;i < nums.length;i++){
			if(nums[i] == targetNum){
				return i;
			}
		}
		return -1;
	}
}
