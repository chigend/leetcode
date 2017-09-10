package valid_sudoku;

public class Solution {
    public static void main(String[] args) {
        char[][] board = {/*{'5','3','.','.','7','.'},
                            {'6','.','.','1','9','5'},
                            {'.','9','8','.','.','.'},
                            {'8','.','.','.','6','.'},
                            {'8','.','.','8','.','3'},
                            {'7','.','.','.','2','.'}*/
                {'.','.','.','.','.','.','5','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'9','3','.','.','2','.','4','.','.'},
                {'.','.','7','.','.','.','3','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','3','4','.','.','.','.'},
                {'.','.','.','.','3','.','.','.','.'},
                {'.','.','.','.','.','5','2','.','.'},
    };
        boolean valid = isValidSudoku(board);
        System.out.println(valid);
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] used = new boolean[9];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = Character.getNumericValue(board[i][j]);
                if (used[num-1]) {
                    return false;
                }
                used[num-1] = true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            boolean[] used = new boolean[9];
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int num = Character.getNumericValue(board[j][i]);
                if (used[num-1]) {
                    return false;
                }
                used[num-1] = true;
            }
        }
        int m = board.length / 3;
        int n = board[0].length / 3;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[] used = new boolean[9];
                for (int k = 3*i; k < 3*(i+1);k++) {
                    for (int l = 3*j; l < 3*(j+1); l++) {
                        if (board[k][l] == '.') {
                            continue;
                        }
                        int num = Character.getNumericValue(board[k][l]);
                        if (used[num-1]) {
                            return false;
                        }
                        used[num-1] = true;
//                        System.out.print(board[k][l]);
                    }
//                    System.out.println();
                }
//                System.out.println();
            }
        }
        return true;
    }
}
