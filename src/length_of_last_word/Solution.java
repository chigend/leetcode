package length_of_last_word;

/**
 * 2016/11/22
 */
public class Solution {
    public static void main(String[] args) {
        lengthOfLastWord("hello world");

    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();

        int index = s.lastIndexOf(" ");
        return s.length() == 0 ? 0 :(index < 0 ? s.length():s.length() - index -1);
    }
}
