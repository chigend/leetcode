package reverse_words_in_a_string_III;

/**
 * @author yejinbiao
 * @create 2017-05-24-12:30
 */

public class Solution2 {
    public static void main(String[] args) {
        String s = reverseWords("Let's take LeetCode contest");
        System.out.println(s.equals("s'teL ekat edoCteeL tsetnoc"));
    }
    public static String reverseWords(String s) {
        String [] words = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(reverse(words[i])).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    private static String reverse(String word){
        char [] chs = word.toCharArray();
        int length = word.length();
        for (int i = 0; i < length/2; i++) {
            char temp = chs[i];
            chs[i] = chs[length - 1 - i];
            chs[length - 1 - i] = temp;
        }
        return new String(chs);
    }
}
