package detect_capital;

/**
 * @author yejinbiao
 * @create 2017-03-10-下午5:45
 */

public class Solution {
    public static void main(String[] args) {
        boolean isCapital = detectCapitalUse2("mEe");
        System.out.println(isCapital);
    }

    public static boolean detectCapitalUse(String word) {
        int total = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            total += c;
        }
        String lowerCase = word.toLowerCase();
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            total -= c;
        }
        total = -total;
        return total == 0 || total == word.length() * 32 || ((total == 32) && Character.isUpperCase(word.charAt(0)));
    }

    public static boolean detectCapitalUse2(String word) {
        if (word.length() <= 1) {
            return true;
        }
        boolean firstUpcase = Character.isUpperCase(word.charAt(0));
        boolean secondUpcase = Character.isUpperCase(word.codePointAt(1));
        for (int i = 1; i < word.length(); i++) {
            if (firstUpcase) {
                if (Character.isUpperCase(word.charAt(i)) != secondUpcase) {
                    return false;
                }
            }else {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
