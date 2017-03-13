package climbing_stairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午4:44
 */

public class Solution {
    private static Map<Integer,Integer>table = new HashMap<>();
    public static void main(String[] args) {
        int stairs = climbStairs(5);
        System.out.print(stairs);
    }

    public static int climbStairs(int n) {
         table.put(1,1);
         table.put(2,2);
         table.put(3,3);
         climb(n);
         return table.get(n);
    }

    private static int climb(int n) {
        Integer stairs = table.get(n);
        if (stairs == null) {
            int climb1 = climb(n - 1);
            table.put(n - 1, climb1);
            int climb2 = climbStairs(n - 2);
            table.put(n - 2, climb2);
            table.put(n, climb1 + climb2);
            return climb1 + climb2;
        }
        return stairs;

    }


}
