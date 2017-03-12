package first_unique_character_in_a_string;

/**
 * @author yejinbiao
 * @create 2017-03-12-下午4:12
 */

public class Solution {
    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        int [] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
