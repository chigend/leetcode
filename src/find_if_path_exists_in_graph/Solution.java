package find_if_path_exists_in_graph;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] union = new int[n];
        for (int i = 0; i < n; i++)
            union[i] = i;
        for (int[] edge : edges) union(union, edge[0], edge[1]);
        return find(union, source) == find(union, destination);
    }

    public void union(int[] union, int p, int q) {
        union[find(union, p)] = find(union, q);
    }

    public int find(int[] union, int x) {
        while (union[x] != x) {
            int t = union[x];
            union[x] = union[union[x]];
            x = t;
        }
        return x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] d = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(solution.validPath(3, d, 0, 2));
    }

}
