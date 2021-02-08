package maximum;

public class Solution {

    public static void main(String[] args) {
        int maximum = maximum( Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(maximum);
    }

    public static int maximum(int a, int b) {
        long al = a;
        long bl = b;
        long abs = abs(al - bl);
        //max(a,b) = 1/2*(a+b+abs(a-b))   这个公式可以到网上看证明
        return (int) ((al + bl + abs) / 2);
    }

    public static long abs(long num) {

        long sign = num >> 63;

        return (num ^ sign) - sign;
    }
}
