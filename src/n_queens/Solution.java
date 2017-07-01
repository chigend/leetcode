package n_queens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-07-01-15:03
 */

public class Solution {
    private static int[] placement;
    private static int size;

    public static void main(String[] args) {
        System.out.println(solveNQueens(8).size());
    }

    public static List<List<String>> solveNQueens(int n) {
        placement = new int[n];
        size = n;
        List<List<String>> result = new ArrayList<>();
        backtrace(0,result);
        return result;
    }

    private static void backtrace(int level,List<List<String>> result) {
        if (level == size) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < placement.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < size - 1; j++) {
                    sb.append('.');
                }
                sb.insert(placement[i],'Q');
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }
        for (int i = 0; i < size; i++) {
            placement[level] = i;
            if (check(level)) {
                backtrace(level + 1, result);
            }
        }
    }
    private static boolean check(int i) {
        for (int j = 0; j < i; j++) {
            if (placement[j] == placement[i] || Math.abs(j- i) == Math.abs(placement[j] - placement[i])) {
                return false;
            }
        }
        return true;
    }
}
