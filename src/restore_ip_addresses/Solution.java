package restore_ip_addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-06-27-9:34
 */

public class Solution {
    private static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        String s = "010010";
        List<String> result = restoreIpAddresses(s);
        System.out.print(result);
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result;
        StringBuilder sb = new StringBuilder();
        backTrace(s,0,0,sb);
        return result;
    }
    private static void backTrace(String s,int start,int level,StringBuilder sb) {
        if (level == 4) {
            if (start >= s.length()) {
                result.add(new String(sb));
            }
        }
        for (int i = 1; i <= 3 && start+i <= s.length(); i++) {
            String str = s.substring(start,start+i);
            int len = str.length();
            int num = Integer.parseInt(str);
            int leastNum = len == 1 ? 0 : (int) Math.pow(10,len-1);
            if (num <= 255 && num >= leastNum) {
                int removeStart = sb.length();
                sb.append(num);
                if (level != 3) sb.append('.');
                backTrace(s,start+i,level+1,sb);
                sb.delete(removeStart,sb.length());
            }
        }

    }
}
