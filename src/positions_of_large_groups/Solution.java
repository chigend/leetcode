package positions_of_large_groups;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "abccdccadfacfdsfasdfasdfdasdfddd";
        List<List<Integer>> lists = largeGroupPositions(s);
        System.out.println(lists);
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        char[] source = s.toCharArray();
        char[] chs = new char[source.length + 1];
        System.arraycopy(source, 0, chs, 0, source.length);
        chs[chs.length - 1] = '-';

        char prev = chs[0];
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (c == prev) {
                count++;
            } else {
                prev = c;
                if (count >= 3) {
                    List<Integer> index = new ArrayList<>();
                    index.add(i - count);
                    index.add(i - 1);
                    res.add(index);
                }
                    count = 1;

            }
        }

        return res;

    }
}
