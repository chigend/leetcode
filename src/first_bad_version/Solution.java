package first_bad_version;

public class Solution {
	public static boolean [] nums = new boolean[]{};
	public static void main(String [] args){
		int n = firstBadVersion(nums.length);
		System.out.println(n);
	}
	public static int firstBadVersion(int n) {
		if(isBadVersion(1)){
			return 1;
		}
        long start = 1;
        long end = n;
        int mid = 0;
        while(start < end){
        	mid = (int) ((start+end)>>1);
        	boolean previous = isBadVersion(mid-1);
        	boolean present = isBadVersion(mid);
        	boolean next = isBadVersion(mid+1);
        	if(!present ){
        		if(next){
        			return mid +1; 
        		}else{
        			start = mid +1;
        			continue;
        		}
        		
        	}else{
        		if(!previous){
        			return mid;
        		}else{
        			end = mid - 1;
        		}
        	}
        }
        return -1;
    }
	
	public static boolean isBadVersion(int version){
		return nums[version - 1];
	}
}
