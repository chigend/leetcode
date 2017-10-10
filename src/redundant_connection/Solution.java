package redundant_connection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] edges = {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
        int[] redundant = findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundant));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        UnionFind find = new UnionFind(edges.length);
        for (int i = 0; i < edges.length; i++) {
            find.union(edges[i][0], edges[i][1]);
        }
        return find.getRes();
    }

    static class UnionFind{
        int[] group;
        int[] size;
        int[] res;

        public UnionFind(int n) {
            res = new int[2];
            group = new int[n];
            for (int i = 0; i < n; i++) {
                group[i] = i;
            }
            size = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (group[x] == x) {
                return x;
            }else {
                group[x] = find(group[x]);
            }
            return group[x];
        }

        public void union(int p, int q) {
            int gp = find(p - 1);
            int gq = find(q - 1);
            if (gp == gq) {
                res[0] = p;
                res[1] = q;
                return;
            }
            if (size[gp] > size[gq]) {
                group[gq] = gp;
                size[gp] += size[gq];
            }else{
                group[gp] = gq;
                size[gq] += size[gp];
            }
        }

        public int[] getRes(){
            return res;
        }
    }
}
