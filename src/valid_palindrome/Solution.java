package valid_palindrome;

/**
 * @author yejinbiao
 * @create 2017-03-14-下午5:02
 */

public class Solution {
    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome("race a car");
        System.out.print(isPalindrome);
    }

    public static boolean isPalindrome(String s) {
        char [] chars = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (low < high && !Character.isLetterOrDigit(chars[low])) {
                low++;
            }
            while (low < high && !Character.isLetterOrDigit(chars[high])) {
                high--;
            }
            if (low >= high) {
                break;
            }
            if (Character.toLowerCase(chars[low++]) != Character.toLowerCase(chars[high--])) {
                return false;
            }

        }
        return true;

    }
}
