package add_strings;

/**
 * @author yejinbiao
 * @create 2017-03-06-上午10:39
 */

public class Solution {
    public static void main(String[] args) {
        String s1 = "6";
        String s2 = "501";
        String sum = addStrings(s1, s2);
        System.out.println(sum);

    }

    public static String addStrings(String num1, String num2) {
        int numLength1 = num1.length();
        int numLength2 = num2.length();
        int minLength = Math.min(numLength1, numLength2);
        int maxLength = Math.max(numLength1, numLength2);
        int bit = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (++bit <= maxLength) {
            int sum = 0;
            if (bit <= minLength) {
                int augend = num1.charAt(numLength1 - bit) - '0';
                int addend = num2.charAt(numLength2 - bit) - '0';
                sum = augend + addend + carry;
            } else if (numLength1 > minLength) {
                int augend = num1.charAt(numLength1 - bit) - '0';
                sum = augend + carry;
            } else {
                int augend = num2.charAt(numLength2 - bit) - '0';
                sum = augend + carry;
            }
            carry = 0;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            sb.insert(0, sum);
        }

        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public static String addStrings2(String num1, String num2) {
        int numLength1 = num1.length();
        int numLength2 = num2.length();
        int minLength = Math.min(numLength1, numLength2);
        int bit = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (++bit <= minLength) {
            int augend = num1.charAt(numLength1 - bit) - '0';
            int addend = num2.charAt(numLength2 - bit) - '0';
            int sum = augend + addend + carry;
            carry = 0;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            sb.insert(0, sum);
        }
        if (numLength1 > minLength) {
            while (bit <= numLength1) {
                int augend = num1.charAt(numLength1 - bit) - '0';
                int sum = augend + carry;
                carry = 0;
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                }
                sb.insert(0, sum);
                bit++;
            }
        } else if (numLength2 > minLength) {
            while (bit <= numLength2) {
                int augend = num2.charAt(numLength2 - bit) - '0';
                int sum = augend + carry;
                carry = 0;
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                }
                sb.insert(0, sum);
                bit++;
            }
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
