package friend_cycles;

/**
 * @author yejinbiao
 * @create 2017-07-18-14:01
 */

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        int cycle = findCircleNum(matrix);
        System.out.println(cycle);
    }

    public static int findCircleNum(int[][] M) {
        int n = M.length;
        FriendCycle cycle = new FriendCycle(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < M[i].length ; j++) {
                if (i < j && M[i][j] == 1) {
                    cycle.union(i, j);
                }
            }
        }
        return cycle.getCount();
    }

    private static class FriendCycle {
        private int count;
        private int[] group;
        private int[] size;

        public FriendCycle(int n) {
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

        public int find(int x) {
            if (group[x] == x) {
                return x;
            } else {
                group[x] = find(group[x]);
            }
            return group[x];
        }

        public void union(int p, int q) {
            int groupP = find(p);
            int groupQ = find(q);
            if (groupP == groupQ) {
                return;
            }
            if (size[groupP] > size[groupQ]) {
                group[groupQ] = groupP;
                size[groupP] += size[groupQ];
            } else {
                group[groupP] = groupQ;
                size[groupQ] += size[groupP];
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
