package first_bad_version;

public class Solution2 {
	public static boolean [] nums = new boolean[]{false,true,true};
	public static void main(String [] args){
	 int n = 	firstBadVersion(3);
	 System.out.println(n);
	}
	public static int firstBadVersion(int n){
		int start = 1;
		int end = n;
		return recursion(start,end);
	}

	private static int recursion(int start, int end) {
		if(start >= end){
			return start;
		}
		int mid = start +(end - start)/2;
		boolean flag = isBadVersion(mid);
		
		if(flag){
			return recursion(start,mid);
		}else{
			return recursion(mid+1,end);
		}
	}
	public static boolean isBadVersion(int version){
		return nums[version - 1];
	}
}
