package search_a_2D_matrix_II;

/**
 * @author yejinbiao
 * @create 2017-06-24-20:03
 */

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},


        };
        boolean find = searchMatrix(matrix,2);
        System.out.println(find);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix,0,matrix.length-1,target);
    }
    private static boolean search(int[][] matrix,int start,int end,int target) {
        if (start > end) return false;
        if (start < end) {
            int med = (start+end) >> 1;
            return search(matrix,start,med,target) ||search(matrix,med+1,end,target);
        }
        return binarySearch(matrix[start],target);
    }
    private static boolean binarySearch(int[] num,int target) {
        int low = 0;
        int high = num.length-1;
        while (low <= high) {
            int med = (low+high)>>1;
            if (num[med] > target) {
                high = med - 1;
            }else if (num[med] < target) {
                low = med + 1;
            }else return true;
        }
        return false;
    }
}
