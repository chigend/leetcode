package max_area_of_island;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int max = maxAreaOfIsland(grid);
        System.out.println(max);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if (grid.length == 0) {
            return max;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int[] count = new int[1];
                    dfs(grid, i, j, count);
                    max = Math.max(max, count[0]);
                }
            }
        }
        return max;
    }

    private static void dfs(int[][] grid, int i, int j, int[] count) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != 1) {
            return;
        }
        count[0]++;
        grid[i][j] = 2;
        dfs(grid, i - 1, j, count);
        dfs(grid, i + 1, j, count);
        dfs(grid, i, j - 1, count);
        dfs(grid, i, j + 1, count);
    }
}
