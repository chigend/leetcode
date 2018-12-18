package largest_number;

import java.util.Arrays;

/**
 * 2016/11/25
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String largestNum = solution.largestNumber(new int[]{0,0,0});
        System.out.println(largestNum);
    }

    public  String largestNumber(int[] num) {
        String[] numStr = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            numStr[i] = String.valueOf(num[i]);
        }
        Arrays.sort(numStr, (a, b) -> (b + a).compareTo(a + b));
        if ("0".equals(numStr[0])) {
            return "0";
        }
        String result = "";
        for (String str : numStr) {
            result += str;
        }
        return result;
    }
}
