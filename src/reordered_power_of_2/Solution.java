package reordered_power_of_2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean canBeReordered = solution.reorderedPowerOf2(821);
        System.out.println(canBeReordered);
    }

    public boolean reorderedPowerOf2(int N) {
        int pow2 = 1;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 31; i++) {
            char[] chs = String.valueOf(pow2 << i).toCharArray();
            Arrays.sort(chs);
            set.add(new String(chs));
        }
        String number = String.valueOf(N);
        char[] chars = number.toCharArray();
        Arrays.sort(chars);
        return set.contains(new String(chars));
    }
}
