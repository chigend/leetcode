package friend_cycles;

/**
 * dfs solution
 */

public class Solution2 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        int cycle = findCircleNum(matrix);
        System.out.println(cycle);
    }

    public  static int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                groups++;
                dfs(i, M, visited);
            }
        }
        return groups;
    }
    private static void dfs(int i, int[][]M, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < M[i].length; j++) {
            if(M[i][j] == 1 && !visited[j]) {
                dfs(j, M, visited);
            }
        }
    }
}
