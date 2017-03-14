package valid_palindrome;

/**
 * @author yejinbiao
 * @create 2017-03-14-下午5:18
 */

public class Solution2 {
    public static void main(String[] args) {
       boolean isPalindrome = isPalindrome("A man, a plan, a canal: Panama");
       System.out.print(isPalindrome);
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int length = s.length();
        char [] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        while (slow < length) {
            while (fast < length && !isDigitOrAlphabet(chars[fast])) {
                fast++;
            }
            if (fast == length) {
                break;
            }
            chars[slow++] = chars[fast++];
        }

        int low = 0;
        int high = slow - 1;
        while (low < high) {
            if (chars[low++] != chars[high--]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isDigitOrAlphabet(char c) {
        return Character.isDigit(c) || Character.isAlphabetic(c);
    }
}
