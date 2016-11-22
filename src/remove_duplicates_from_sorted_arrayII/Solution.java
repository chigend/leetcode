package remove_duplicates_from_sorted_arrayII;

public class Solution {
	public static void main(String[] args) {

	}

	public int removeDuplicates(int[] nums) {
		if(nums.length == 0 || nums.length ==1){
			return nums.length;
		}
		
		int presentNum = nums[0];
		int count = 1;
		boolean [] saved = new boolean[nums.length];
		saved[0] = true;
		for(int i=1;i<nums.length;i++){//注意是从1开始，因为第一个数已经取过了
			if(presentNum != nums[i] ){
				saved[i] = true;
				presentNum = nums[i];
				count = 1;
 			}else if(presentNum == nums[i] && ++count <=2){//因为此处presentNum == nums[i],所以在运算后面之前应该先++count
				saved[i] = true;
				count++;
			}
		}
		int newLength = 0;
		for(int i=0;i<saved.length;i++){
			if(saved[i]){
				nums[newLength++] = nums[i];
			}
		}
		return newLength;
	}
}
