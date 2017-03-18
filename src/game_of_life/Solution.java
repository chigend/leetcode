package game_of_life;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-18-下午2:53
 */

public class Solution {
    public static void main(String[] args) {
        int[][] board = {{1,0,1,1}, {1,0,1,0}, {0,1,1,0}, {0,0,1,1}};
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        int[] neibours = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                neibours[i * n + j] = calculateNeibours(i, j, board);
            }
        }

        for (int i = 0; i < neibours.length; i++) {
            int row = i / n;
            int col = i % n;
            int liveNeibours = neibours[i];
            if (board[row][col] == 1) {
                if (liveNeibours < 2 || liveNeibours > 3) {
                    board[row][col] = 0;
                }
            } else {
                if (liveNeibours == 3) {
                    board[row][col] = 1;
                }

            }
        }
        for (int i = 0; i < board.length;i++) {
            System.out.print(Arrays.toString(board[i]));
        }

    }

    private static int calculateNeibours(int row, int col, int[][] board) {
        int rowStart = Math.max(0, row - 1);
        int rowEnd = Math.min(board.length - 1, row + 1);
        int colStart = Math.max(0, col - 1);
        int colEnd = Math.min(board[0].length - 1, col + 1);
        int liveNeibours = 0;
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if ((i != row || j != col) && board[i][j] == 1) liveNeibours++;
            }
        }
        return liveNeibours;
    }
}
