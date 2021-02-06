package count_the_number_of_consistent_strings;

import tool.ArrayPrinter;
import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {

        String[] strings = ArrayTestCaseTransformer.transformString("[\"ad\",\"bd\",\"aaab\",\"baa\",\"badab\"]");
        System.out.println(countConsistentStrings("ab", strings));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = new boolean[26];
        char[] chars = allowed.toCharArray();
        for (char c : chars) {
            allow[c - 'a'] = true;
        }
        int count = 0;
        for (String word : words) {
            if (valid(allow, word)) {
                count++;
            }
        }
        return count;
    }

    public static boolean valid(boolean[] allow, String word) {
        char[] wordChars = word.toCharArray();
        for (char wordChar : wordChars) {
            if (!allow[wordChar - 'a']) {
                return false;
            }
        }
        return true;
    }
}
