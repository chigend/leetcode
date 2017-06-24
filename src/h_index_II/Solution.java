package h_index_II;

/**
 * @author yejinbiao
 * @create 2017-06-24-16:54
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,3,5,6};
        int hIndex = hIndex(nums);
        System.out.println(hIndex);
    }

    public static int hIndex(int[] citations) {
        int len = citations.length;
        int low = 1;
        int high = len;

        while (low <= high){
           int med = low + ((high-low) >> 1);
           if (citations[len-med] >= med) {
               //if current index match and index+1 does not match,the current index is max
               if (med == len || citations[len-(med+1)] < med+1) {
                   return med;
               }else {
                   //there is a higher index that match
                   low = med + 1;
               }
           }else {
               high = med - 1;
           }
        }
        return 0;

    }
}
