package judge_route_circle;

/**
 * @author yejinbiao
 * @create 2017-08-15-9:25
 */

public class Solution {
    public static void main(String[] args) {
        boolean flag = judgeCircle("UD");
        System.out.println(flag);
    }

    public static boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        char[] chs = moves.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (c == 'U') {
                vertical++;
            }else if (c == 'D') {
                vertical--;
            }else if (c == 'R') {
                horizontal++;
            }else {
                horizontal--;
            }
        }
        return horizontal == 0 && vertical == 0;
    }
}
