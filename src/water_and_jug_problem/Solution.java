package water_and_jug_problem;

/**
 * @author yejinbiao
 * @create 2017-03-03-下午12:16
 */

/**
 * 本题是个数学问题，可根据裴蜀定理(Bézout's identity)来求 (site:https://en.wikipedia.org/wiki/B%C3%A9zout's_identity)
 */
public class Solution {

    public static void main(String [] args) {
        boolean flag = canMeasureWater(0,2 ,1);
        System.out.println(flag);
    }
    public static boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % gcd(x, y) == 0;

    }

    /**
     * get the great common divisor  求最大公约数  此处使用辗转相除法
     * 求a和b最大公约数(a，b)的步骤如下：用a除以b，得a÷b=q......r1(0≤r1)。
     * 若r1=0，则(a，b)=b；若r1≠0，则再用b除以r1，得b÷r1=q......r2 (0≤r2）.
     * 若r2=0，则(a，b)=r1，若r2≠0，则继续用r1除以r2，……如此下去，直到能整除为止。
     * 其最后一个为被除数的余数的除数即为(a, b)。
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        int mod = b;
        while (mod != 0) {
            int temp = b;
            mod = a % b;
            a = temp;
            b = mod;
        }
        return a;
    }

    /**
     * get the great common divisor  求最大公约数  此处使用辗转相减法
     * 求a和b最大公约数(a，b)的步骤如下：假设a，b中大数为hight，小的数为low，用hight减去low，得high-low=d
     * 若d≠0 则用low和d中的大数减去小数,
     * 若d=0 则最大公约数为high或low，以此类推
     * @param a
     * @param b
     * @return
     */
    private int gcd2(int a, int b) {
        if( a == 0 ) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        int low = a > b ? b:a;
        int hight = a + b -low;
        int difference = -1;
        while ( (difference = hight - low) != 0) {
            hight = difference > low ? difference:low;
            low = difference + low - hight;
        }
        return hight;
    }
}
