package fair_candy_swap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] swap = solution.fairCandySwap(new int[]{1,1}, new int[]{2,2});
        System.out.println(Arrays.toString(swap));
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int aliceTotal = 0;
        int bobTotal = 0;
        HashSet<Integer> bobBars = new HashSet<>();
        for (int barSize : A) {
            aliceTotal += barSize;
        }
        for (int barSize : B) {
            bobBars.add(barSize);
            bobTotal += barSize;
        }
        int delta = (aliceTotal - bobTotal) >> 1;
        for(int barSize : A) {
            int requireBob = barSize - delta;
            if (bobBars.contains(requireBob)){
                return new int[]{barSize, requireBob};
            }
        }
        return new int[]{};
    }
}
