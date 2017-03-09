package reverse_vowels_of_a_string;

/**
 * @author yejinbiao
 * @create 2017-03-09-下午1:07
 */

public class Solution {
    public static void main(String[] args) {
        String s = reverseVowels("Unglad, I tar a tidal gnu.");
        System.out.println(s);
    }
    public static String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char [] vowels = new char[] {'a','e','i','o','u','e','A','E','I','O','U'};

        char [] chars = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (low < high && !isVowel(vowels,chars[low])) {
                low ++;
            }
            while (low < high && !isVowel(vowels,chars[high])) {
                high--;
            }
            if (low >= high) {
                break;
            }
            char c = chars[low];
            chars[low] = chars[high];
            chars[high] = c;
            low++;
            high--;
        }
        return new String(chars);
    }
    private static  boolean isVowel(char [] vowels, char c) {
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }
}
