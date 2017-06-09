package distribute_candies;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yejinbiao
 * @create 2017-06-09-10:10
 */

public class Solution {
    public static void main(String[] args) {
        int maxKind = distributeCandies(new int[]{1,1,2,3});
        System.out.println(maxKind);
    }

    public static int distributeCandies(int[] candies) {
        Set <Integer> kinds = new HashSet<>();
        for (int kind : candies) {
            kinds.add(kind);
        }
        return Math.min(kinds.size(),candies.length/2);
    }
}
