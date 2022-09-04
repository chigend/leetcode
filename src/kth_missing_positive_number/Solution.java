package kth_missing_positive_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findKthPositive(new int[]{2}, 1);
    }

    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;

        //用二分法寻找最后一个missing数字小于 k的index
        while(l < r){
            int mid = (l + r + 1) >> 1;
            int diff = arr[mid] - mid - 1;
            if(diff < k) l = mid;
            else r = mid - 1;
        }

        //但是有可能找不到小于k的index，例如  arr=[2,10]  k=1   arr=[3] k =2 ,这种情况就是开头missing了，所以直接是k
        int d = arr[r] - r - 1;
        return d < k ? r +  k  + 1 : k;

    }
}
