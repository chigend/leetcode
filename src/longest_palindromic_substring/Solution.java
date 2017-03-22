package longest_palindromic_substring;

/**
 * @author yejinbiao
 * @create 2017-03-20-下午5:12
 */

public class Solution {
    private static int start = 0;
    private static int maxLen = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int count = 0;
        int x = 65530;
        while (x != 0) {
            x |= x + 1;
            count++;
        }
        System.out.print(count);
    }

    public static String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            longestSubstring(s, i, i);
            longestSubstring(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }
    private static void longestSubstring(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        int len = high - low - 1;
        if (len > maxLen) {
            maxLen = len;
            start = low+1;
        }

    }
}
