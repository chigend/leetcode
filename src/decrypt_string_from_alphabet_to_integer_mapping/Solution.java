package decrypt_string_from_alphabet_to_integer_mapping;

public class Solution {

    public static void main(String[] args) {
        String s = freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#");
        System.out.println(s);
    }

    public static String freqAlphabets(String s) {
        char[] chs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '#') {
                count++;
            }
        }
        int length = s.length() - 2 * count;
        char[] string = new char[length];
        int index = length - 1;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == '#') {
                i -= 2;
                string[index--] = (char) (Integer.parseInt(new String(chs, i, 2)) - 1 + 'a');
            } else {
                string[index--] = (char) (chs[i] - '0' - 1 + 'a');
            }
        }
        return new String(string);
    }
}
