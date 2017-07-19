package number_of_islands;

/**
 * @author yejinbiao
 * @create 2017-07-19-9:56
 */

public class Solution {
    public static void main(String[] args) {
        char[][] islands = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
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
        Island island = new Island(m * n);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        island.union(i * n + j, i * n + (j + 1));
                    }
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        island.union(i * n + j, (i + 1) * n + j);
                    }
                }else {
                    island.decreaseIsland();
                }
            }
        }
        return island.getCount();
    }

    private static class Island {
        private int count;
        private int[] group;
        private int[] size;
        public Island(int n) {
            count = n;
            group = new int[n];
            for (int i = 0; i < n; i++) {
                group[i] = i;
            }
            size = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
            }
        }
        private int find(int i) {
            if (group[i] == i) {
                return i;
            }else {
                group[i] = find(group[i]);
            }
            return group[i];
        }

        public void union(int i, int j) {
            int groupI = find(i);
            int groupJ = find(j);
            if(groupI == groupJ) {
                return;
            }
            if (size[groupI] > size[groupJ]) {
                group[groupJ] = groupI;
                size[groupI] += size[groupJ];
            }else {
                group[groupI] = groupJ;
                size[groupJ] += size[groupI];
            }
            count--;
        }

        public int getCount() {
            return count;
        }

        public void decreaseIsland() {
            count--;
        }
    }
}
