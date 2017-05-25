package word_search;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author yejinbiao
 * @create 2017-05-25-15:41
 */

public class Solution {
    public static void main(String[] args) {
                        char [][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
//                char[][] board = {{'a'}};
//                char [][]board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        char[][]board = {{'A','B','C','B'}};
        boolean exist = exist(board, "ABCB");
        System.out.println(exist);
    }
    public static boolean exist(char[][] board, String word) {
        char[] chs = word.toCharArray();
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && search(used, board, word, 0, i, j)) {
                    return true;
                }
                used[i][j] = false;
            }
        }
        return false;
    }

    private static boolean search(boolean[][] used, char[][] board, String word, int cusor, int row, int col) {
        if (cusor == word.length()) return true;

        if (word.charAt(cusor) == board[row][col] && !used[row][col]) {
            if (cusor == word.length() - 1) return true;
            used[row][col] = true;

            if (row - 1 >= 0 && !used[row-1][col]) {

                boolean up = search(used, board, word, cusor + 1, row - 1, col);
                if (up)
                    return true;
                used[row - 1][col] = false;
            }
            if (col + 1 < board[0].length && !used[row][col+1]) {

                boolean right = search(used, board, word, cusor + 1, row, col + 1);
                if (right)
                    return right;
                used[row][col + 1] = false;
            }
            if (row + 1 < board.length&& !used[row+1][col]) {

                boolean down = search(used, board, word, cusor + 1, row + 1, col);
                if (down)
                    return true;
                used[row + 1][col] = false;
            }
            if (col - 1 >= 0 && !used[row][col-1]) {
                boolean left = search(used, board, word, cusor + 1, row, col - 1);
                if (left)
                    return true;
                used[row][col - 1] = false;
            }
        }
        return false;
    }
}
