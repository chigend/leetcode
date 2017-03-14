package reverse_integer;

/**
 * @author yejinbiao
 * @create 2017-03-14-下午4:01
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
       long n = x;
       long result = 0;
       while (n != 0) {
           long digit = n % 10;
           result = result * 10 + digit;
           if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
               return 0;
           }
           n /= 10;
       }
       return (int)result;
    }
}
