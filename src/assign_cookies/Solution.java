package assign_cookies;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-24-下午8:02
 */

public class Solution {
    public static void main(String[] args) {
        int [] greedy = {1,2};
        int [] size = {1,2,3};
        int count = findContentChildren(greedy, size);
        System.out.print(count);
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int slow = 0;
        int fast = 0;
        int count = 0;
        while (slow < g.length && fast < s.length) {
            if (g[slow] <= s[fast]) {
                slow++;
                count++;
            }
            fast++;
        }
        return count;
    }
}
