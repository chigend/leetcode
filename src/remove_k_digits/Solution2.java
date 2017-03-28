package remove_k_digits;

/**
 * @author yejinbiao
 * @create 2017-03-28-下午3:02
 */

public class Solution2 {
    public static void main(String[] args) {
        String s = removeKdigits("10200", 1);
        System.out.println(s);
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        char[] nums = new char[num.length()];//use array as stack,
        char[] chars = num.toCharArray();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            /**
             *   when there are numbers in stack and can delete(k > 0) and the
             *   current number is less than the stack top number,we should delete
             *   the top number ,we pop the stack top number(which repents as index--)
             */
            while (index > 0 && k > 0 && chars[i] < nums[index - 1]) {
                index--;
                k--;
            }
            //we push every number into stack
            nums[index++] = chars[i];
        }
        /**
         * since the number in the stack is in ascending order, so when there are
         * some more digits we can delete, just delete the stack top number,
         * which is also represent as index--
         */
        while (k > 0) {
            index--;
            k--;
        }
        int start = 0;
        /**
         *remove leading zeroes,if the stack contains only zeroes, we should keep the last zero
         * which represents as start < index - 1
         */

        while (start < index - 1) {
            if (nums[start] != '0') break;
            start++;
        }
        StringBuilder sb = new StringBuilder();
        //in the last,there are some digits that we should keep ,just append it to result;
        while (start < index) sb.append(nums[start++]);
        return sb.toString();
    }

}
