package valid_parenthesis_string;

public class Solution {
    public static void main(String[] args) {
        String s = "*)((()(*(((()())()))()()*)((*)))()))(*)(()()(((()*()()((()))((((";
        System.out.println(s.length());
        boolean valid = checkValidString(s);
        System.out.println(valid);
    }

    public static boolean checkValidString(String s) {
        return checkValidString(s.toCharArray(), 0, 0);
    }

    public static boolean checkValidString(char[] chars, int cursor, int unMatch) {
        if (chars.length - cursor < unMatch) {
            return false;
        }
        if (cursor == chars.length) {
            return unMatch == 0;
        }
        if (chars[cursor] == '(') {
            return checkValidString(chars, cursor + 1, unMatch + 1);
        } else if (chars[cursor] == ')') {
            //when match right ,there must be unMatch left
            if (unMatch == 0) {
                return false;
            }
            return checkValidString(chars, cursor + 1, unMatch - 1);
        } else {
            return checkValidString(chars, cursor + 1, unMatch + 1)
                    //  when match right ,there must be unMatch left
                    || (unMatch > 0 && checkValidString(chars, cursor + 1, unMatch - 1))
                    || checkValidString(chars, cursor + 1, unMatch);
        }
    }
}
