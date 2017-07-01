package n_queens_II;

/**
 * @author yejinbiao
 * @create 2017-07-01-15:03
 */

public class Solution {
    private static int[] placement;
    private static int size;
    private static int count;

    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }

    public static int totalNQueens(int n) {
        placement = new int[n];
        size = n;
        backtrace(0);
        return count;
    }

    private static void backtrace(int level) {
        if (level == size) {
            count++;
            return;
        }
        for (int i = 0; i < size; i++) {
            placement[level] = i;
            if (check(level)) {
                backtrace(level + 1);
            }
        }
    }

    private static boolean check(int i) {
        for (int j = 0; j < i; j++) {
            if (placement[j] == placement[i] || Math.abs(j - i) == Math.abs(placement[j] - placement[i])) {
                return false;
            }
        }
        return true;
    }
}
