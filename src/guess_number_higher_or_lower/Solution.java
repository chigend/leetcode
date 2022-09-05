package guess_number_higher_or_lower;

import java.util.Random;

public class Solution {
	public static int target = 1;
	public static void main(String[] args) {
		Solution solution = new Solution();
		Random r = new Random();

		target = r.nextInt(100) + 1;
		System.out.println("目标数字:"+target);
		System.out.println(solution.guessNumber(target));
	}

	public  int guessNumber(int n) {
		int l  = 1;
		int r = n;
		while(l < r){
			int mid = r + (l - r >> 1);
			int res = guess(mid);
			if(res == -1){
				r = mid;
			}else {
				l = mid + 1;
			}
		}
		return guess(r) == 0 ? r: r - 1;
	}
	
	public static int guess(int guess){
		if(guess > target){
			return -1;
		}else if(guess < target){
			return 1;
		}else{
			return 0;
		}
		
	}
}
