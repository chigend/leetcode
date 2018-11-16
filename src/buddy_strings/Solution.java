package buddy_strings;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean isBuddy = solution.buddyStrings("ab", "bc");
        System.out.println(isBuddy);
    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int diffCount = 0;
        char[] chs1 = A.toCharArray();
        char[] chs2 = B.toCharArray();
        //first different index
        int j = -1;
        int[] alphabet = new int[26];
        for (int i = 0; i < chs1.length; i++) {
            alphabet[chs1[i] - 'a']++;
            if (chs1[i] != chs2[i]) {
                diffCount++;
                if (diffCount == 1) {
                    j = i;
                }else if (diffCount == 2){
                    if (chs2[j] != chs1[i] || chs1[j] != chs2[i]){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        boolean existSameCharacter = false;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > 1) {
                existSameCharacter = true;
                break;
            }
        }
        //两种情况, 一:字符串有恰好两个字符不同, 二:字符串相同,但是同一个字符出现大于两次,可以理解为交换相同的字符
        return diffCount == 2 || diffCount == 0 && existSameCharacter;
    }
}
