package repeated_DNA_sequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * bit manipulation solution,since there are four distinct character (A,C,G,T) we can use two bits to represent every character
 */
public class Solution {
    public static void main(String[] args) {
                System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
//        System.out.println(Integer.parseInt("11111111111111111111", 2));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() <= 10) {
            return result;
        }
        char[] chs = s.toCharArray();
        int num = 0;
        Set<Integer> sequences = new HashSet<>();
        Set<Integer> repeated = new HashSet<>();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            num = bitManipulation(num, c);
            if (i >= 9) {
                int target = num & 1048575;
                if (i > 9) {
                    if (sequences.contains(target) && !repeated.contains(target)) {
                        String sequence = s.substring(i - 9, i + 1);
                        result.add(sequence);
                        repeated.add(target);
                    }
                }
                //1048575 appears to be 20 bits filled with 1  (00000000000011111111111111111111)
                sequences.add(target);
            }
        }
        return result;
    }

    private static int bitManipulation(int num, char c) {

        if (c == 'A') {
            num <<= 2;
        } else if (c == 'C') {
            num <<= 2;
            num |= 1;
        } else if (c == 'G') {
            num <<= 2;
            num |= 2;
        } else {
            num <<= 2;
            num |= 3;
        }
        return num;
    }
}
