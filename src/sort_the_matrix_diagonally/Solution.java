package sort_the_matrix_diagonally;

public class Solution {
    public static void main(String[] args) {

    }

    public int[][] diagonalSort(int[][] mat) {
        if (mat.length == 0) return mat;
        int m = mat.length;
        int n = mat[0].length;
        for(int j = 0; j < n; j ++) {
            int row = 0;
            int col = j;
            int [] bucket = new int[101];
            while(row < m && col < n) {
                bucket[mat[row++][col++]] += 1;
            }
            for(int i = bucket.length - 1; i >= 0; i-- ) {
                while(bucket[i]-- > 0) {
                    mat[--row][--col] = i;
                }
            }
        }

        for(int i = 1; i < m; i ++) {
            int row = i;
            int col = 0;
            int [] bucket = new int[101];
            while(row < m && col < n) {
                bucket[mat[row++][col++]] += 1;
            }
            for(int j = bucket.length - 1; j >= 0; j-- ) {
                while(bucket[j]-- >0) {
                    mat[--row][--col] = j;
                }
            }
        }
        return mat;
    }
}
