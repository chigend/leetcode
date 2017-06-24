package h_index;

/**
 * @author yejinbiao
 * @create 2017-06-24-19:25
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3,0,6,1,5};
        System.out.print(hIndex(nums));
    }

    public static int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len+1];
        for (int citation : citations) {
            if (citation >= len) {
                count[len]++;
            }else {
                count[citation]++;
            }
        }
        int total = 0;
        for (int i = len; i > 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}
