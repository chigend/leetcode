package number_of_segments_in_a_string;

/**
 * @author yejinbiao
 * @create 2017-03-17-下午2:05
 */

public class Solution {
    public static void main(String[] args) {
        String s = "   Hello,    my name is John   ";
        int count = countSegments(s);
        System.out.print(count);
    }

    public static int countSegments(String s) {
        if (s == null) return 0;
        int count = 0;
        boolean firstSpace = false;
        char [] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] > 32) {
                firstSpace = true;
            }else if (firstSpace) {
                count++;
                firstSpace = false;
            }

        }
        return count + (firstSpace ? 1:0);
    }
}
