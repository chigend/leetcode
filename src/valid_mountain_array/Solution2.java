package valid_mountain_array;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        boolean validMountain = solution2.validMountainArray(new int[]{1,2,1,0,-1});
        System.out.println(validMountain);
    }

    public boolean validMountainArray(int[] A) {
        int i = 0;
        while (i < A.length - 1 && A[i] < A[i+1]) {
            i++;
        }
        if (i == 0 || i == A.length - 1) {
            return false;
        }
        while (i < A.length - 1 && A[i] > A[i + 1]) {
            i++;
        }
        return i == A.length - 1;
    }
}
