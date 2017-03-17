package is_subsequence;

/**
 * two pointer solution
 */

public class Solution {
    public static void main(String[] args) {

        String s = "";
        String t = "ahbgdc";
        boolean isSubsequence = isSubsequence(s,t);
        System.out.print(isSubsequence);

    }

    public static boolean isSubsequence(String s, String t) {
        int slow = 0;
        int fast = 0;
        char [] schars = s.toCharArray();
        char [] tchars = t.toCharArray();
        while (slow < s.length()) {
            while (fast < t.length() && schars[slow] != tchars[fast]) {
                fast++;
            }
            if (fast == t.length()) {
                return false;
            }
            slow++;
            fast++;

        }
        return true;
    }
}
