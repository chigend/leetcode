package count_binary_substrings;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int count = countBinarySubstrings("");
        System.out.println(count);
    }

    public static int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        char[] chs = s.toCharArray();
        char previous = chs[0];
        int start = 0;
        for (int i = 1; i < chs.length; i++) {
            char c = chs[i];
            if (c != previous) {
                res.add(i - start);
                start = i;
                previous = c;
            }
        }
        res.add(chs.length - start);
        int count = 0;
        for (int i = 1; i < res.size(); i++) {
            int min = Math.min(res.get(i - 1), res.get(i));
            count += min;
        }
        return count;
    }
}
