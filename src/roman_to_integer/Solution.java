package roman_to_integer;

/**
 * @author yejinbiao
 * @create 2017-03-13-上午11:21
 */

public class Solution {
    public static void main(String[] args) {
        int sum = romanToInt("CCXXIV");
        System.out.println(sum);
    }

    public  static int romanToInt(String s) {
        int len = s.length();
        char [] chars = s.toCharArray();
        int [] romans = new int[256];
        romans['M'] = 1000;
        romans['D'] = 500;
        romans['C'] = 100;
        romans['I'] = 1;
        romans['L'] = 50;
        romans['V'] = 5;
        romans['X'] = 10;
        int sum = 0;
        sum += romans[chars[len - 1]];
        for (int i = len - 2; i >= 0; i--) {
            int num = romans[chars[i]];
            if (num < romans[chars[i + 1]]) {
                sum -= num;
            }else {
                sum += num;
            }
        }
        return sum;
    }
}
