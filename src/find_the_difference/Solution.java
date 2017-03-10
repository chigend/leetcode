package find_the_difference;

/**
 * @author yejinbiao
 * @create 2017-03-09-下午4:21
 */

public class Solution {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "dacbg";
        char c = findTheDifference(s, t);
        System.out.println(c);
    }
    public static  char findTheDifference(String s, String t) {
        int [] alphabet = new int [26];
        for (int i = 0; i < s.length(); i ++) {
            alphabet[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i ++) {
            alphabet[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < alphabet.length; i ++) {
            if (alphabet[i] < 0) {
                return (char)(i + 'a');
            }
        }
        return ' ';
    }

}
