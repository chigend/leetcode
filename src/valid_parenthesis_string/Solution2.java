package valid_parenthesis_string;

public class Solution2 {
    public static void main(String[] args) {

    }

    public static boolean checkValidString(String s) {
        char[] chs = s.toCharArray();
        /***
         * record the least open left parentheses and most open left parentheses
         * least open is only if the symbol is '(' we count it,
         * but most open is include '*'
         */
        int least = 0;
        int most = 0;
        for (int i = 0; i < chs.length; i++) {
            least += chs[i] == '(' ? 1 : -1;
            most += chs[i] != ')' ? 1 : -1;
            if (most < 0) {
                break;
            }
            least = Math.max(0, least);
        }
        return least == 0;
    }
}
