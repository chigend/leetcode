package reverse_words_in_a_string_III;

/**
 * @author yejinbiao
 * @create 2017-05-12-18:17
 */

public class Solution {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        s = reverseWords(s);
        System.out.print(s);
    }

    public static String reverseWords(String s) {
        char [] chars = s.toCharArray();
        int start = 0;
        int end = -1;
        while ((end = s.indexOf(' ',start)) != -1) {
            reverse(chars,start,end-1);
            start = end + 1;
        }
        //由于是以空格来作为单词的结束字符，那么最后单词没有空格的情况就需要单独反转
        reverse(chars,start,s.length()-1);
        return new String(chars);
    }
    private static void reverse(char[]chars,int start,int end){
        for (int i = start,count=0; i <= (start + end) >> 1; i++,count++) {
            char temp = chars[i];
            chars[i] = chars[end - count];
            chars[end - count] = temp;
        }
    }
}
