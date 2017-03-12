package random_note;

/**
 * @author yejinbiao
 * @create 2017-03-12-下午1:13
 */

public class Solution {
    public static void main(String [] args) {
        boolean canConstruct = canConstruct("ac","cba");
        System.out.println(canConstruct);
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int [] alphabet = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            alphabet[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (alphabet[ransomNote.charAt(i) - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }
}
