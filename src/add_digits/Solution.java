package add_digits;

/**
 * @author yejinbiao
 * @create 2017-03-06-下午2:06
 */

public class Solution {
    public static void main(String [] args) {
        System.out.print(addDigits(56));
    }
    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return addDigits(sum);
    }
}
