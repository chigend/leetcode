package intersection_of_two_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
	
	public static void main(String [] args){
		int [] nums1 = new int[]{1,2,2,3,5,6,7,2,32,34,23};
		int []nums2= new int[]{2,2,23};
		int [] result = intersection(nums1, nums2);
		System.out.println(Arrays.toString(result));
	}
	 public static  int[] intersection(int[] nums1, int[] nums2) {
	        if(nums1.length ==0 || nums2.length==0){
	        	return new int[0];
	        }
	        Arrays.sort(nums1);
	        Set<Integer> result = new HashSet<Integer>();
	        for(int i =0;i<nums2.length;i++){
	        	int index = binarySearch(nums1, nums2[i]);
	        	if(index != -1){
	        		result.add(nums2[i]);
	        	}
	        	
	        }
	        int [] array = new int[result.size()];
	        int size = 0;
	      for(Iterator <Integer> it = result.iterator();it.hasNext();){
	    	  int i = it.next();
	    	  array[size++] = i;
	      }
	      return array;
	    }
	 public static  int binarySearch(int[]nums,int target){
		 Arrays.sort(nums);
		 int start = 0;
		 int end = nums.length - 1;
		 int mid = 0;
		 while(start <= end){
			 mid = (start+end)>>1;
			 if(nums[mid] > target){
				 end = mid - 1;
				 continue;
			 }else if(nums[mid] < target){
				 start = mid + 1;
				 continue;
			 }else{
				return mid; 
				}
		 }
		 return -1;
	 }
	 
}
