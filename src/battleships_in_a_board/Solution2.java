package battleships_in_a_board;

/**
 * dfs solution with O(n) space
 */

public class Solution2 {
    public static void main(String[] args) {
        char[][] islands = {
                {'X', '.', '.', 'X'},
                {'1', '1', '0', 'X'},
                {'0', '0', '1', 'X'},
                {'0', '1', '0', 'X'}
        };
        int count = countBattleships(islands);
        System.out.println(count);
    }

    public  static int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }
        int n = board[0].length;
        boolean[] visited = new boolean[m * n];
        int battleShips = 0;
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (board[i][j] == 'X' && !visited[i * n + j]) {
                   battleShips++;
                   dfs(i, j, visited, board);
               }
           }
       }
       return battleShips;
    }

    private static void dfs(int i, int j, boolean[]visited, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || board[i][j] != 'X'
                || visited[i * n + j]) {
            return;
        }
        visited[i * n + j] = true;
        dfs(i - 1, j , visited, board);
        dfs(i + 1, j , visited, board);
        dfs(i, j - 1, visited, board);
        dfs(i, j + 1, visited, board);
    }
}
