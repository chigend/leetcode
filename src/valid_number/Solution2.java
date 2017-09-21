package valid_number;

public class Solution2 {
    public static void main(String[] args) {

    }

    public boolean isNumber(String s) {
        s = s.trim();
        boolean numSeen = false;
        boolean eSeen = false;
        boolean numAfterE = false;
        boolean pointSeen = false;
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = chs[i];
            if (Character.isDigit(c)) {
                numSeen = true;
                numAfterE = true;
            }else if (c == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            }else if (c == 'e') {
                if (eSeen  || !numSeen) {
                    return false;
                }
                numAfterE = false;
                eSeen = true;
            }else if (c == '+' || c == '-') {
                if (i != 0 && chs[i - 1] != 'e') {
                    return false;
                }
            }else {
                return false;
            }
        }

        return numSeen && numAfterE;
    }

}
