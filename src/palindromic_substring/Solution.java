package palindromic_substring;

public class Solution {
    private static int count = 0;
    public static void main(String[] args) {
        int count = countSubstrings("aaaaaa");
        System.out.println(count);
    }

    public static int countSubstrings(String s) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            countPalindrome(i, i, chs);
            countPalindrome(i, i + 1, chs);
        }
        return count;
    }
    private static void countPalindrome(int low, int high, char[] chs) {
        while (low >= 0 && high <= chs.length - 1 && chs[low] == chs[high]) {
            low--;
            high++;
            count++;
        }
    }
}
