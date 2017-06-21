package range_addition_II;

/**
 * @author yejinbiao
 * @create 2017-06-21-10:26
 */

public class Solution {
    public static void main(String[] args) {
        int maxCount =  maxCount(3,3,new int[][]{{2,2},{3,3}});
        System.out.println(maxCount);
    }

    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        Integer minRow = Integer.MAX_VALUE;
        Integer minCol = Integer.MAX_VALUE;
        for(int i = 0; i < ops.length; i++){
            minRow = Math.min(ops[i][0],minRow);
            minCol = Math.min(ops[i][1],minCol);
        }
        return minRow * minCol;
    }
}
