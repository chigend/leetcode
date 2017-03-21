package longest_palindrome;

/**
 * @author yejinbiao
 * @create 2017-03-21-上午9:30
 */

public class Solution {
    public static void main(String[] args) {
        String s = "aa";

        int count = longestPalindrome(s);
        System.out.print(count);

    }

    public static int longestPalindrome(String s) {
        int maxOddCount = 0;
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
            if (count != 0) {
                /**
                 * 如果是偶数，那么直接加上这个偶数，因为偶数一定能组成回文
                 */
                if (count % 2 == 0) res += count;
                else {
                    /**
                     * 如果是奇数的话，就计算最大的奇数，并且把每次奇数小的数减一加到结果里
                     */
                    if (maxOddCount != 0) {
                        res += Math.min(maxOddCount, count) - 1;
                    }
                    maxOddCount = Math.max(maxOddCount, count);
                }
            }
        }
        res += maxOddCount;
        return res;
    }

}
