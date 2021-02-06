package shuffle_string;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        System.out.println(restoreString("art", ArrayTestCaseTransformer.transform("[1,0,2]")));
    }

    public static String restoreString(String s, int[] indices) {
        char[] chs = new char[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chs[indices[i]] = chars[i];
        }
        return new String(chs);
    }
}
