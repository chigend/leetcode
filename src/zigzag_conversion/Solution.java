package zigzag_conversion;

/**
 * @author yejinbiao
 * @create 2017-03-17-下午5:48
 */

public class Solution {
    public static void main(String[] args) {
        String s = convert("PAYPALISHIRING", 1);
        System.out.print(s);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int distance = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int row = 0; row < numRows; row++) {
            /**
             * 通过分析可知，由两部分组成，下半圈和上半圈，
             * 并且下半圈与上半圈的和与行数有关，distance = 2 * numRows - 2;
             */
            int difference = distance - 2 * row;
            int j = row;
            while (j < s.length()) {
                /**
                 * 下半圈的两字符距离为distance - 2*row
                 */
                if (difference != 0) {
                    sb.append(chars[j]);
                    j += difference;
                }
                if (j >= s.length()) {
                    break;
                }
                /**
                 * 上半圈的距离为 2 * row
                 */
                if (row != 0) {
                    sb.append(chars[j]);
                    j += 2 * row;
                }
            }
        }
        return sb.toString();
    }
}
