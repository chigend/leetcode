package ugly_number;

/**
 * @author yejinbiao
 * @create 2017-03-26-18:25
 */

public class Solution {
    public static void main(String[] args) {
        boolean isUgly = isUgly(14);
        System.out.println(isUgly);
    }

    public static boolean isUgly(int num) {
        if (num <= 0) return false;
        num = help(num, 2);
        num = help(num, 3);
        num = help(num,5);
        return num == 1;
    }

    private static int help(int n, int mod) {
        while (n % mod == 0) n /= mod;
        return n;
    }
}
