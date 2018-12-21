package peak_index_in_a_mountain_array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int peakIndex = solution.peakIndexInMountainArray(new int[]{1,9,10,11,14,6,5,4,3,2,1});
        System.out.println(peakIndex);
    }

    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (A[mid] > A[mid + 1]) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
