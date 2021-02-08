package available_captures_for_rook;

public class Solution {

    public static void main(String[] args) {
        char[][] chars = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        int i = numRookCaptures(chars);
        System.out.println(i);
    }

    public static int numRookCaptures(char[][] board) {
        int ri = 0, rj = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    ri = i;
                    rj = j;
                    break;
                }
            }
        }
        int count = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            for (int step = 1; ; step++) {
                int x = ri + step * dx[i];
                int y = rj + step * dy[i];
                if (x < 0 || y < 0 || x >= 8 || y >= 8 || board[x][y] == 'B') {
                    break;
                }

                if (board[x][y] == 'p') {
                    count++;
                    break;
                }
            }
        }

        return count;

    }
}
