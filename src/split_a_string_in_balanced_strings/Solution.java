package split_a_string_in_balanced_strings;

public class Solution {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        char[] chs = s.toCharArray();
        int balance = 0;

        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            balance += c == 'L' ? 1 : -1;
            if (balance == 0) {
                count++;
            }
        }
        return count;
    }
}
