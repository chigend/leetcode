package sqrt;

/**
 * 2016/11/23
 */
public class Solution {
    public static void main(String[] args) {
        int result = mySqrt(3);
        System.out.println(result);

    } public static int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int low = 1;
        int high = x;
        while (low<high){
            int mid = (low+high)>>1;
            int result = x/mid;

            if(result > mid){
                low = mid;
            }else if(result < mid){
                high = mid;
            }else {
                return mid;
            }
            if(high - low ==1){
                break;
            }
        }
        return low;
    }

}
