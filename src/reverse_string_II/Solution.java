package reverse_string_II;

/**
 * @author yejinbiao
 * @create 2017-03-12-下午9:35
 */

public class Solution {
    public static void main(String[] args) {
        String str = "ab";
         str = reverseStr(str,3);
         System.out.print(str);
    }

    public static String reverseStr(String s, int k) {
        char [] chars = s.toCharArray();
        int len = chars.length;
        int start = 0;
        int end = k - 1;
        while (start < len) {
            int low = start;
            int high = Math.min(end, len - 1);
            while (low < high) {
                char temp = chars[high];
                chars[high] = chars[low];
                chars[low] = temp;
                System.out.println();
                low++;
                high--;
            }
            start += 2 * k;
            end = start + k - 1;
        }
        return new String(chars);
    }
}
