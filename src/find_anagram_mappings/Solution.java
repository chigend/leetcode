package find_anagram_mappings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        A = anagramMappings(A, B);
        System.out.println(Arrays.toString(A));
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = map.get(A[i]);
        }
        return A;
    }
}
