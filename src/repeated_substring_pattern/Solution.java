package repeated_substring_pattern;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午5:42
 */

public class Solution {
    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaaaaaaaaa";
        boolean repeat = repeatedSubstringPattern(str);
        System.out.println(repeat);
    }

    public static boolean repeatedSubstringPattern(String s) {
        int sLength = s.length();
        out:
        for (int slices = 2; slices <= sLength; slices++) {
            if (sLength % slices == 0) {
                int subLen = sLength / slices;
                String repeatString = s.substring(0, subLen);
                for (int i = subLen; i < s.length(); i += subLen) {
                    String substring = s.substring(i, i + subLen);
                    if (!repeatString.equals(substring)) {
                        continue out;
                    }
                }
                return true;
            }
        }
        return false;
    }
}


