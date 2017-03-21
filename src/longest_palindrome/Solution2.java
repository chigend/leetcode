package longest_palindrome;

/**
 *
 * Solution1 的优化方案
 */

public class Solution2 {
    public static int longestPalindrome(String s) {
        int res = 0;
        int[] alphabets = new int[256];
        char[] chars = s.toCharArray();
        /**
         * 首先统计每个字符出现的次数
         */
        for (int i = 0; i < s.length(); i++) alphabets[chars[i]]++;
        /**
         * 遍历统计字符字数的字典
         */
        for (int i = 0; i < alphabets.length; i++) {
            int count = alphabets[i];
            /**
             * 如果count是偶数，那么count/2*2还是原来的数
             * 如果count是奇数,那么count/2*2就成原来的数-1  比如：5   5／2*2=4
             * 那么这样计算下来结果应该是少一的，因为最大的那个奇数，是可以用来作回文的，因为可以放在最中间
             *
             */
            res += count / 2 * 2;
        }
        /**
         * 如果最长回文不是原来字符串的长度，说明这其中有奇数个字符，那么就加上最大的那个奇数少掉的一
         */
        return s.length() == res ? res : res + 1;
    }
}
