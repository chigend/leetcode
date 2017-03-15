package minesweeper;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-15-上午10:47
 */

public class Solution {
    public static void main(String[] args) {
        char [][] board = {{'B','1','E','1','B'},
                        {'B','1','M','1','B'},
                        {'B','1','1','1','B'},
                {'B','B','B','B','B'}};
        updateBoard(board,new int[]{1,2});
        for (int i = 0; i < board.length;i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        revealSquare(board,row,col);
        return board;
    }
    private static void revealSquare(char[][] board,int row, int col) {
        /**
         * if click the mine,it should boom and return
         */
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return;
        }
        /**
         * get the border of current square
         */
        int leftBorder = Math.max(0, col - 1);
        int rightBorder = Math.min(board[0].length - 1, col + 1);
        int topBorder = Math.max(0, row - 1);
        int bottomBorder = Math.min(board.length - 1, row + 1);
        int mines = 0;
        for (int i = topBorder; i <= bottomBorder; i++) {
            for (int j = leftBorder; j <= rightBorder; j ++) {
                if (i == row && j == col) {
                    continue;
                }
                /**
                 * count the mines
                 */
                if (board[i][j] == 'M') {
                    mines++;
                }
            }
        }
        /**
         * if mines > 0,mark the square to mines
         */
        if (mines != 0) {
            board[row][col] = (char) (mines + '0');
            return;
        }
        /**
         * if the mines is zero,set the current square to 'B',which means blank,
         * and reveal
         */
        board[row][col] = 'B';
        for (int i = topBorder; i <= bottomBorder; i++) {
            for (int j = leftBorder; j <= rightBorder; j ++) {
                /**
                 * reveal the square (above,below,right,left,and all 4 diagonals)
                 * except  itself and the square that has benn revealed.
                 */
                if ((i != row || j != col) && board[i][j] != 'B') {
                    revealSquare(board,i,j);
                }
            }
        }
    }
}
