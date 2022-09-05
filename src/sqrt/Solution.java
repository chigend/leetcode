package sqrt;

/**
 * 2016/11/23
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = mySqrt(2147483647);
        System.out.println(result);

    }

    public static int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        int l = 1;
        int r = x;
        while (l < r) {
            int mid = r + (l - r >> 1);
            if (x / mid <= mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return x / r < r ? r - 1 : r;
    }

}
