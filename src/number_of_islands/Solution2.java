package number_of_islands;

/**
 * @author yejinbiao
 * @create 2017-07-19-12:58
 */

public class Solution2 {
    public static void main(String[] args) {
        char[][] islands = {
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '1', '0', '1', '1'}
        };
        int count = numIslands(islands);
        System.out.println(count);
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int position = i * n + j;
                if (grid[i][j] == '1' && !visited[position]) {
                    islands++;
                    dfs(i, j, visited, grid);
                }
            }
        }
        return islands;
    }

    private static void dfs(int i, int j, boolean[] visited, char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] != '1' || visited[i * n + j]) {
            return;
        }
        visited[i * n + j] = true;
        dfs(i - 1, j, visited, grid);
        dfs(i + 1, j, visited, grid);
        dfs(i, j - 1, visited, grid);
        dfs(i, j + 1, visited, grid);
    }
}
