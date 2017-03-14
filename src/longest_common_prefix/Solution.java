package longest_common_prefix;

/**
 * @author yejinbiao
 * @create 2017-03-14-上午9:49
 */

public class Solution {
    public static void main(String[] args) {
        String [] str = {"ab","abc","abc","abd"};
        String prefix = longestCommonPrefix(str);
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        /**
         * the max prefix length will be the shortest string in the array
         */
        int maxPrefixLength = Integer.MAX_VALUE;
        for (String str : strs) {
            maxPrefixLength = Math.min(maxPrefixLength, str.length());
        }
        out:
        for (int prefixLength = maxPrefixLength; prefixLength > 0; prefixLength--) {
            String prefix = strs[0].substring(0, prefixLength);
            char[] prefixChars = prefix.toCharArray();
            for (int i = 1; i < strs.length; i++) {
                char[] str = strs[i].toCharArray();
                int p = 0;
                int s = 0;
                while (p < prefixLength) {
                    if (prefixChars[p++] != str[s++]) {
                        continue out;
                    }
                }
            }
            return prefix;
        }
        return "";
    }
}
