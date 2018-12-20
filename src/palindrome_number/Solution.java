package palindrome_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean s = solution.isPalindrome(1221);
        System.out.println(s);
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String s = String.valueOf(x);
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (chs[i] != chs[chs.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
