package reverse_only_letters;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("----"));
    }

    public static String reverseOnlyLetters(String S) {
        char[] chs = S.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(chs[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(chs[j])) {
                j--;
            }

            char temp = chs[j];
            chs[j] = chs[i];
            chs[i] = temp;
            i++;
            j--;
        }
        return new String(chs);
    }


}
