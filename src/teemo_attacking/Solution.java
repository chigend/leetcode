package teemo_attacking;

/**
 * @author yejinbiao
 * @create 2017-03-11-下午1:31
 */

public class Solution {
    public static void main(String[] args) {
        int [] timeSeries = {1,2};
        int duration = 2;
        int total = findPoisonedDuration(timeSeries, duration);
        System.out.println(total);
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length <= 1) {
            return duration * timeSeries.length;
        }
        int total = 0;
        for (int i = 1; i < timeSeries.length; i ++) {
            total += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        //the last attack
        total += duration;
        return total;
    }
}
