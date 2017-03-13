package longest_substring_without_repeating_characters;

/**
 * @author yejinbiao
 * @create 2017-03-13-上午9:14
 */

public class Solution {
    public static void main(String[] args) {
        String str = "pwwkew";
        int maxLen = lengthOfLongestSubstring(str);
        System.out.print(maxLen);
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int maxLen = 0;
        int[] counts = new int[256];
        char[] chars = s.toCharArray();
        /**
         * a pointer track the start of no-repeat character of substring
         */
        int slow = 0;
        /**
         * a pointer to scan the string
         */
        int fast = 0;
        while (slow < len) {
            /**
             * if the character is not repeat, just move down the fast pointer
             */
            while (fast < len && counts[chars[fast]]++ < 1) {
                fast++;
            }
            /**
             * when fast reach the length of string or there appear repeat character,
             * calculate the non-repeating substring's length,and replace the maxLen
             * if necessary
             */
            maxLen = Math.max(maxLen, fast - slow);
            /**
             * if fast reach the length of string,return the result
             */
            if (fast == len) {
                return maxLen;
            }
            /**
             * since it appear repeat character,it's time to find to new start where
             * there are no repeat character in subtring(slow,fast),
             * when the character at fast pointer appear more than once, just count down
             * the character at slow pointer,and move slow pointer
             */
            while (counts[chars[fast]] > 1) {
                counts[chars[slow]]--;
                slow++;
            }
            fast++;
        }
        return maxLen;
    }
}
