package reorder_log_files;

import java.util.Arrays;

/**
 *  haven't be optimized
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] result = solution.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
        System.out.println(Arrays.toString(result));
    }

    public String[] reorderLogFiles(String[] logs) {
        int i = logs.length - 1, j = logs.length - 1;
        while (i >= 0) {
            String log = logs[i];
            int firstSpace = log.indexOf(' ');
            if (Character.isDigit(log.charAt(firstSpace + 1))) {
                String temp = logs[j];
                logs[j--] = logs[i];
                logs[i] = temp;
            }
            i--;
        }
        Arrays.sort(logs, 0, j + 1, (o1, o2) -> {
            int start1 = o1.indexOf(' ');
            int start2 = o2.indexOf(' ');
            char[] chs1 = o1.toCharArray();
            char[] chs2 = o2.toCharArray();
            String afterIndentifier = new String(chs1, start1, o1.length() - start1);
            String afterIndentifier2 = new String(chs2, start2, o2.length() - start2);
            String indentifier1 = new String(chs1, 0, start1);
            String indentifier2 = new String(chs2, 0, start2);
            int compare = afterIndentifier.compareTo(afterIndentifier2);
            return compare == 0 ? indentifier1.compareTo(indentifier2) : compare;
        });
        return logs;
    }
}
