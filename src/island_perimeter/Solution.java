package island_perimeter;

/**
 * @author yejinbiao
 * @create 2017-03-10-下午2:42
 */

public class Solution {
    public static void main(String[] args) {
        int [][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
//        int [][] grid = {
//                {1,1},
//        };
        int perimeter = islandPerimeter2(grid);
        System.out.println(perimeter);
    }

    public static int islandPerimeter(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        /**
         * a table to record if it is a island for previous row
         */
        boolean [] topIsCell = new boolean[grid[0].length];
        int border = 0;
        int cell = 0;
        for (int i = 0; i < grid.length; i++) {
            /**
             * a mark to record if it is a island for previous column
             */
            boolean previousIsCell = false;
            for (int j = 0; j < grid[i].length; j++) {
                boolean isCell = grid[i][j] == 1;
                if (isCell) {
                    if (topIsCell[j]) {
                        border++;
                    }
                    if (previousIsCell) {
                        border++;
                    }
                    cell++;
                }
                previousIsCell = isCell;
                topIsCell[j] = isCell;
            }
        }
        return cell * 4 - border * 2;
    }

    public static int islandPerimeter2(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int internalBorder = 0;
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0 && grid[i - 1][j] == 1) {
                        internalBorder++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        internalBorder++;
                    }
                  island ++;
                }
            }
        }
        return island * 4 - internalBorder * 2;
    }
}
