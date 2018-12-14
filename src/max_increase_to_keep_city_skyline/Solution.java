package max_increase_to_keep_city_skyline;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int increment = solution.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}});
        System.out.println(increment);
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] horizon = new int[grid.length];
        int[] vertical = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int height = grid[i][j];
                horizon[j] = Math.max(horizon[j], height);
                vertical[i] = Math.max(vertical[i], height);
            }
        }

        int increment = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int height = grid[i][j];
                increment += Math.min(horizon[j], vertical[i]) - height;
            }
        }
        return increment;
    }
}