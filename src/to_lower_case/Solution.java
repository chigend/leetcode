package to_lower_case;

public class Solution {
    public static void main(String[] args) {
        System.out.println(toLowerCase("HeLLO"));
    }

    public static String toLowerCase(String str) {
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (c >= 'A' && c <= 'Z') {
                chs[i] = (char)(c + 32);
            }
        }
        return new String(chs);
    }


}
