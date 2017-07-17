package solve_the_equation;

/**
 * @author yejinbiao
 * @create 2017-07-17-10:33
 */

public class Solution {
    public static void main(String[] args) {
        String result = solveEquation("x=x+2");
        System.out.println(result);
    }
    public static String solveEquation(String equation) {
        int index = equation.indexOf('=');
        String left = equation.substring(0, index);
        String right = equation.substring(index + 1);
        int[] leftRes = calculate(left);
        int[] rightRes = calculate(right);
        int countX = leftRes[0] - rightRes[0];
        int sum = rightRes[1] - leftRes[1];
        if (countX == 0 && sum == 0) {
            return "Infinite solutions";
        }
        if (countX == 0 && sum != 0) {
            return "No solution";
        }
        int result = sum / countX;
        return "x=" + result;
    }

    private static int[] calculate(String expression) {
        int sum = 0;
        boolean plus = true;
        int num = 0;
        int x = 0;
        char[] chs = expression.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (c == 'x') {
                if (i == 0 || chs[i - 1] != '0') {
                    int count = num == 0 ? 1 : num;
                    x += plus ? count : -count;
                }
                num = 0;
            }else if (c >= '0' && c <= '9'){
                num = num * 10 + (c - '0');
            }else {
                sum += plus ? num : -num;
                num = 0;
                plus = c == '+';
            }
        }
        sum += plus ? num : -num;
        return new int[] {x, sum};
    }
}
