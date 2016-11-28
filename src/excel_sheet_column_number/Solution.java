package excel_sheet_column_number;

/**
 * 2016/11/25
 */
public class Solution {
    public static void main(String[] args) {
        int result = titleToNumber("Z");
        System.out.print(result);
    }

    public static int titleToNumber(String s) {
        int result = 0;
        char [] chs = s.toCharArray();
        int length = chs.length;
        for (int i =0;i<length;i++){
            int base = chs[i] - 'A'+1;
            result += base * Math.pow(26,length-i-1);
        }
        return result;
    }
}
