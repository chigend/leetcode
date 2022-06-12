package find_words_that_can_be_formed_by_characters;

public class Solution {
    public static void main(String[] args) {
        String[]words = new String[]{"abca"};
        String chars = "abc";
        int i = countCharacters(words, chars);
        System.out.println(i);
    }

    public static int countCharacters(String[] words, String chars) {

        int[] alphabet = new int[26];
        char[] chs = chars.toCharArray();
        for (char c : chs) {
            alphabet[c - 'a']++;
        }
        int len = 0;
        for (String word : words) {
            int[] copy = new int[26];
            System.arraycopy(alphabet   , 0, copy, 0, 26);
            if (acknowledged(word, copy)) {
                len += word.length();
            }
        }
        return len;
    }

    public static boolean acknowledged(String word, int[] chars) {
        char[] wordChs = word.toCharArray();
        for (char c : wordChs) {
            if (chars[c - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }
}
