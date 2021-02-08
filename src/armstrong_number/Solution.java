package armstrong_number;

public class Solution {

    public static void main(String[] args) {

    }

    public boolean isArmstrong(int N) {
        int k = String.valueOf(N).length();
        int sum = N;
        while(N != 0) {
            int d = N % 10;
            N /= 10;
            sum -= (int)Math.pow(d, k);
        }
        return sum == 0;
    }
}
