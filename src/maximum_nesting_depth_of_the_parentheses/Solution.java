package maximum_nesting_depth_of_the_parentheses;

public class Solution {

    public static void main(String[] args) {
        System.out.println(maxDepth("1"));
    }

    public static int maxDepth(String s) {
        int count = 0;

        int max = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                max = Math.max(max, ++count);
            } else if (c == ')') {
                count--;
            }
        }
        return max;
    }
}
