package string_compression;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int len = compress(input);
        System.out.println(Arrays.toString(input));
        System.out.println(len);
    }

    public static int compress(char[] chars) {
        char pre = chars[0];
        int slow = 0;
        int count = 1;
        for (int i = 1; i <= chars.length; i++) {
            if (i < chars.length && chars[i] == pre) {
                count++;
            } else {
                chars[slow++] = pre;
                if (count > 1) {
                    char[] counts = String.valueOf(count).toCharArray();
                    int j = 0;
                    while (j < counts.length) {
                        chars[slow++] = counts[j];
                        j++;
                    }
                }
                count = 1;
                if (i < chars.length) {
                    pre = chars[i];
                }

            }
        }
        return slow;
    }
}
