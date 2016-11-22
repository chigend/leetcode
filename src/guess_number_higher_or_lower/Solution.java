package guess_number_higher_or_lower;

import java.util.Random;

public class Solution {
	public static int target = 1;
	public static void main(String[] args) {
			Random r = new Random();
			int n = 1;
//			target = r.nextInt(n) + 1;
			int result = guessNumber(n);
			System.out.println(result);
	}

	public static int guessNumber(int n) {
		long start  = 1;
		long end = n;
		int guessNumber = 0;
		while(start <= end){
			guessNumber =(int) ((start+end)>>1);
			int response = guess(guessNumber);
			if(response == -1){
				end = guessNumber - 1;
				continue;
			}else if(response == 1){
				start = guessNumber + 1;
				continue;
			}else{
				return guessNumber;
			}
		}
		return -1;
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
