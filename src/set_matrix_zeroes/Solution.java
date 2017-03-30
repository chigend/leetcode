package set_matrix_zeroes;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.Arrays;

/**
 * O(m+n)space solution
 */

public class Solution {
    public static void main(String[] args) {
        int [][] matrix = {
                {1,0,1,0,1},
                {0,1,1,1,1},
                {1,1,1,1,1},
                {0,0,1,1,1}
        };
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        boolean [] row = new boolean[matrix.length];
        boolean [] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) matrix[i][j] = 0;
            }
        }

    }
}
