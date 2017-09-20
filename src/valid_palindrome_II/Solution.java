package valid_palindrome_II;

public class Solution {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }

    public static boolean validPalindrome(String s) {
        return validPalindrome0(s.toCharArray(), 0, s.length() - 1, false);
    }

    //since there are at most one delete chance, use a boolean variable to indicate if the chance has used
    public static boolean validPalindrome0(char[] chs, int start, int end, boolean deleted) {
        while (start <= end) {
            if (chs[start] == chs[end]) {
                start++;
                end--;
            }else if (!deleted) {
                /**
                 *  if the delete chance has not been used, just delete character at start and character
                 *  at end in two ways and mark the deleted variable as true
                 */
                return validPalindrome0(chs, start, end - 1, true)
                        || validPalindrome0(chs, start + 1, end, true);
            }else {
                //if chs[start] != chs[end] and deleted chance has used just return false
                return false;
            }
        }
        return true;
    }
}
