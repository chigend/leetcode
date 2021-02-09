package confusing_number;

public class Solution {

    public static void main(String[] args) {
        System.out.println(confusingNumber(25));
    }

    public static boolean confusingNumber(int N) {
        int[] reverses = new int[]{0,1,-1,-1,-1,-1,9,-1,8,6};
        int num = N;

        int rnum = 0;
        while(num != 0) {
            int mod = num % 10;
            int reverse = reverses[mod];
            if(reverses[mod] == -1) {
                return false;
            }
            rnum = rnum * 10 + reverse;
            num /= 10;
        }
        return rnum != N;
    }
}
