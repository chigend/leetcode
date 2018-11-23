package unique_email_addresses;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int uniqueEmail = solution.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
        System.out.println(uniqueEmail);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmail = new HashSet<>();
        for (String email : emails) {
            int i = 0;
            char[] chs = email.toCharArray();
            boolean ignore = false;
            for (int j = 0; j < chs.length; j++) {
                char c = chs[j];
                if (c == '+') {
                    ignore = true;
                }else if (c == '@'){
                    String genuineMail = new String(chs, 0, i) + new String(chs, j, chs.length - j);
                    uniqueEmail.add(genuineMail);
                }else if (!ignore && c != '.') {
                    chs[i++] =chs[j];
                }
            }
        }
        return uniqueEmail.size();
    }
}
