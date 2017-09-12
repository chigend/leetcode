package count_and_say;

public class Solution {
    public static void main(String[] args) {
        String sequence = countAndSay(10000000);
        System.out.println(sequence);
    }

    public static String countAndSay(int n) {
        String sequence = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] chars = sequence.toCharArray();
            char cur = chars[0];
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                char c = chars[i];
                if (c == cur) {
                    count++;
                }else {
                    sb.append(count).append(cur);
                    cur = c;
                    count = 1;
                }
            }
            sb.append(count).append(cur);
            sequence = sb.toString();
        }
        return sequence;
    }
}
