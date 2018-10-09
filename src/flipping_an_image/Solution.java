package flipping_an_image;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
     int[][] a = {{1,1,0},{1,0,1},{0,1,1}};
     a = flipAndInvertImage(a);
     for (int i = 0; i < a.length; i++) {
         System.out.println(Arrays.toString(a[i]));
     }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length;
        for (int i = 0; i < A.length; i++) {
            //交换数据的同时反转数据,奇数长度的数组最中间的值反转不到
            for (int j = 0; j < len / 2; j++) {
                int temp = A[i][j];
                A[i][j] = 1 ^ A[i][len - 1 - j];
                A[i][len - 1 - j] = 1 ^ temp;
            }
            //如果长度是奇数,则反转中间的数
            A[i][len / 2] = (len & 1) ^ A[i][len / 2];
        }
        return A;
    }
}
