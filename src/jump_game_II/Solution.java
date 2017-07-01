package jump_game_II;

/**
 * @author yejinbiao
 * @create 2017-07-01-20:40
 */

public class Solution {
    public static void main(String[] args) {
        int steps = jump(new int[] {1,2});
        System.out.println(steps);
    }
    public static int jump(int[] nums) {
        int max = 0;//最大能到的步数
        int end = 0;//本次跳跃最大跳到位置
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                step++;
                end = max;
            }
        }
        return step;
    }
}
