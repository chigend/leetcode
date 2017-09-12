package repeated_DNA_sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        List<String>s = findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(s);
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String sequence = s.substring(i, i + 10);
            if (seen.contains(sequence)) {
                repeated.add(sequence);
            }
            seen.add(sequence);
        }
        return new ArrayList<>(repeated);
    }
}
