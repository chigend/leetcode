package climbing_stairs;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午5:01
 */

public class Solution2 {
    private static int[] steps = null;

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }

    public static int climbStairs(int n) {
        if (n < 4) {
            return n;
        }
        int[] steps = new int[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        steps[3] = 3;
        if (n < 4) {
            return steps[n];
        }
        for (int i = 4; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];

        }
        return steps[n];
    }
}
