package license_key_formatting;

/**
 * @author yejinbiao
 * @create 2017-03-22-下午12:23
 */

public class Solution {
    public static void main(String[] args) {
        String format = licenseKeyFormatting("saaa",3);
        System.out.print(format);
    }

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        char [] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
            }
        }
        int mod = sb.length() % K;
        /**
         * 如果能整除9／3  2条横杆
         * 不能整除 8／3  2条横杆
         * 可以通过减去1来再除
         */
        int count = (sb.length() - 1) / K;
        int startInsert = mod == 0 ? K : mod;
        while (count-- > 0) {
            sb.insert(startInsert, '-');
            startInsert += K + 1;
        }
        return sb.toString();
    }
}
