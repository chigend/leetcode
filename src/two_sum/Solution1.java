package two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//hash solution
public class Solution1 {
		public static void main(String [] args){
			System.out.println(Arrays.toString(twoSum(new int[]{3,2,4},6)));
		}
	  public  static int[] twoSum(int[]nums , int target){
		  	int [] indexs = new int[2];
		  	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		  	for(int i =0;i<nums.length;i++){
		  		if(!map.containsKey(target - nums[i])){
		  			map.put(nums[i], i);
		  		}else{
		  			indexs[0] = map.get(target-nums[i]);
		  			indexs[1] = i;
		  			break;
		  		}
		  	}
		  	return indexs;
	  }
}
