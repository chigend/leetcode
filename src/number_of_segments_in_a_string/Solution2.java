package number_of_segments_in_a_string;

/**
 * re
 */

public class Solution2 {
    public static void main(String[] args) {
        String s = "Hello, my name   is John";
        int count = countSegments(s);
        System.out.print(count);
    }

    public static int countSegments(String s) {
        if(s == null || (s = s.trim()).length() == 0) {
            return 0;
        }
        return s.split("\\s+").length;
    }

}
