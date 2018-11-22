package valid_mountain_array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean mountain = solution.validMountainArray(new int[]{0,1,2,1,2});
        System.out.println(mountain);
    }
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int previous = A[0];
        int mountain = -1;
        for (int i = 1; i < A.length; i++) {

            if (mountain == -1) {
                //if peak not found, the array should not walk down the hill
                if (A[i] <= previous) {
                    return false;
                }
                //if after the current element, the mountain will walk down, the current is the peak;
                if (i < A.length - 1 && A[i] > A[i + 1]) {
                    mountain = i;
                }
            }else {
                //if peak has been found, the array should not walk up the hill
                if (A[i] >= previous) {
                    return false;
                }
            }
            previous = A[i];
        }
        //the peak must be found
        return mountain != -1;
    }
}
