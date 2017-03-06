package base_7;

/**
 * @author yejinbiao
 * @create 2017-03-06-上午10:12
 */

public class Solution {
    public static void main(String [] args) {
        String base7 = convertToBase7(-100);
        System.out.println(base7);
    }
    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }else if (num > 0) {
            return calculate(num);
        }else {
            return "-" + calculate(-num);
        }

    }
    private static String calculate(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int mod = num % 7;
            num /= 7;
            sb.insert(0,mod);
        }
        return sb.toString();
    }
}
