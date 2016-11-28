package largest_number;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 2016/11/25
 */
public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            System.out.println(Integer.toBinaryString(1 << i));

        }
    }

    public static String largestNumber(int[] num) {
        String result = IntStream.of(num)
                .mapToObj(Integer::toString)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining(""));
        //"00"应该返回"0"
        return result.charAt(0) == '0' ? "0" : result;

    }
}
