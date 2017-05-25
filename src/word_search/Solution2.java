package word_search;

/**
 * @author yejinbiao
 * @create 2017-05-25-17:36
 */

public class Solution2 {
    public static void main(String[] args) {
//        char [][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//                char[][] board = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
//                        char[][] board = {{'a'}};
                        char [][]board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        //        char[][]board = {{'A','B','C','B'}};
        boolean exist = exist(board, "AAB");
        System.out.println(exist);
    }

    public static boolean exist(char[][] board, String word) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == word.charAt(0) && search(board, word, 1, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, String word, int cusor, int row, int col) {
        if (cusor == word.length())
            return true;
        char temp = board[row][col];
        board[row][col] = '#';
        char target = word.charAt(cusor);
        if (row - 1 >= 0) {
            if (target == board[row - 1][col] && search(board, word, cusor + 1, row - 1, col)) {
                return true;
            }
        }

        if (col + 1 < board[0].length) {
            if (target == board[row][col + 1] && search(board, word, cusor + 1, row, col + 1)) {
                return true;
            }
        }
        if (row + 1 < board.length) {
            if (target == board[row + 1][col] && search(board, word, cusor + 1, row + 1, col)) {
                return true;
            }
        }
        if (col - 1 >= 0) {
            if (target == board[row][col - 1] && search(board, word, cusor + 1, row, col - 1)) {
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    }
}
