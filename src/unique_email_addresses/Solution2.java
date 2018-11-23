package unique_email_addresses;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int uniqueEmail = solution.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
        System.out.println(uniqueEmail);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmail = new HashSet<>();
        for (String email : emails) {
            char[] chs = email.toCharArray();
            int end = email.indexOf('@');
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < end; i++) {
                if (chs[i] == '+') {
                    break;
                }else if (chs[i] != '.') {
                    sb.append(chs[i]);
                }
            }
            sb.append(new String(chs, end, chs.length - end));
            uniqueEmail.add(sb.toString());
        }
        return uniqueEmail.size();
    }
}
