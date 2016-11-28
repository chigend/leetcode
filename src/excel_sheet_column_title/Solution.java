package excel_sheet_column_title;

/**
 * 2016/11/23
 */
public class Solution {
    public static void main(String[] args) {
        convertToTitle(28);
    }

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int mod = 0;
        while (n != 0) {
            sb.insert(0,(char)(--n % 26 + 'A'));
            n = n / 26;
        }

        return sb.toString();
    }
}
