package reverse_words_in_a_string;

/**
 * @author yejinbiao
 * @create 2017-03-09-下午1:49
 */

public class Solution {
    public static void main(String[] args) {
        String s = reverseWords("sss    sss  dsad");
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        char [] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int start = s.length() - 1;
        int end = start;
        while (start >= 0) {
            if (chars[start] > ' ') {
                start --;
                continue;
            }else {
                result.append(chars, start + 1, end - start);
                result.append(' ');
            }
            while (chars[start] <= ' ') {
                start --;
            }
            end = start;
        }
        result.append(chars, start + 1, end - start);
        return result.toString();
    }
}
