package decode_string;

public class Solution2 {
    public static void main(String[] args) {
        String s = decodeString("100000000[leet]");
        System.out.println(s);
    }

    public static String decodeString(String s) {
        return decodeString0(s, new int[]{0});
    }
    //the key to the recursive solution is that we should keep track of the current pos although we call method cursively
    //one way is to return the pos the recursive method has get in array pattern(the first element is the result, the second in the pos)
    //another way we can pass a array param which store the pos to the recursive method.
    public static String[] decodeString0(String s, int pos) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        int curK = 0;
        for (; pos < chars.length; pos++) {
            char c = chars[pos];
            if (Character.isDigit(c)) {
                while (Character.isDigit(chars[pos])) {
                    curK = 10 * curK + Character.getNumericValue(chars[pos++]);
                }
                String[] temp = decodeString0(s, ++pos);
                res.append(generateString(curK, temp[0]));
                pos = Integer.valueOf(temp[1]);
                curK = 0;
            } else if (c == ']') {
                return new String[]{res.toString(), String.valueOf(pos)};
            } else {
                res.append(c);
            }
        }
        return new String[]{res.toString()};
    }

    public static String decodeString0(String s, int[] pos) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        int curK = 0;
        for (; pos[0] < chars.length; pos[0]++) {
            char c = chars[pos[0]];
            if (Character.isDigit(c)) {
                while (Character.isDigit(chars[pos[0]])) {
                    curK = 10 * curK + Character.getNumericValue(chars[pos[0]++]);
                }
                //ignore the '['
                ++pos[0];
                String temp = decodeString0(s, pos);
                res.append(generateString(curK, temp));
                curK = 0;
            } else if (c == ']') {
                return res.toString();
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    private static String generateString(int times, String template) {
        if (times == 1) {
            return template;
        }
        if ((times & 1) == 0) {
            return generateString(times / 2, template + template);
        } else {
            return generateString((times - 1) / 2, template + template) + template;
        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < times; i++) {
//            stringBuilder.append(template);
//        }
//        return stringBuilder.toString();
    }
}
