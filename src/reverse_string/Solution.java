package reverse_string;

/**
 * @author yejinbiao
 * @create 2017-03-09-下午12:32
 */

public class Solution {
    public static void main(String[] args) {

        String s = "helloworld";
        s  = reverseString(s);
        System.out.println(s);
    }

    public static String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int low = 0;
        int high = s.length() - 1;
        char [] chars = s.toCharArray();
        while (low < high) {
            char c = chars[low];
            chars[low] = chars[high];
            chars[high] = c;
            low++;
            high--;
        }
        return new String(chars);
    }
}
