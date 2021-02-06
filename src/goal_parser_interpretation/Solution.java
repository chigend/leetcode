package goal_parser_interpretation;

public class Solution {

    public static void main(String[] args) {

        System.out.println(interpret("G()(al)"));
        System.out.println(interpret("(al)G(al)()()G"));
        System.out.println(interpret("G()()()()(al)"));
    }

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        char[] chars = command.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            switch (c) {
                case 'G':
                    sb.append(c);
                    break;
                case '(':
                    break;
                case 'a':
                    sb.append("al");
                    i += 2;
                    break;
                case ')':
                    sb.append('o');
                default:
            }
        }
        return sb.toString();
    }

}
