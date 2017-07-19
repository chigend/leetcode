package battleships_in_a_board;

/**
 * union find solution
 */

public class Solution {
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

    public static int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }
        int n = board[0].length;
        BattleShip ship = new BattleShip(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (j < n - 1 && board[i][j + 1] == 'X') {
                        ship.union(i * n + j, i * n + (j + 1));
                    }
                    if (i < m - 1 && board[i + 1][j] == 'X') {
                        ship.union(i * n + j, (i + 1) * n + j);
                    }
                }else {
                    ship.decrease();
                }
            }
        }
        return ship.getCount();
    }

    private static class BattleShip {
        private int count;
        private int[] group;

        public BattleShip(int n) {
            count = n;
            group = new int[n];
            for (int i = 0; i < n; i++) {
                group[i] = i;
            }

        }

        private int find(int x) {
            if (group[x] == x) {
                return x;
            }else {
                group[x] = find(group[x]);
                return group[x];
            }
        }

        public void union(int i, int j) {
            int groupI = find(i);
            int groupJ = find(j);
            if (groupI == groupJ) {
                return;
            }

                group[groupJ] = groupI;


            count--;
        }
        public void decrease() {
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
