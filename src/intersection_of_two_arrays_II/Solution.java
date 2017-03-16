package intersection_of_two_arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-16-下午2:06
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums1 = {1};
        int [] nums2 = {1};
        int [] intersection = intersect(nums1,nums2);
        System.out.print(Arrays.toString(intersection));
    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //apointer表示a数组当前的数
        int apointer = 0;
        //bpointer 表示b数组当前的数
        int bpointer = 0;
        while (true) {
            /**
             * 以数组nums1为参照，如果nums2当前的数比nums1当前的数小，那么说明nums2数组当前的数没有重复
             * 就跳过这些数，（前提是nums2数组角标没越界）
             */
            while (bpointer < len2 && nums2[bpointer] < nums1[apointer]) {
                bpointer++;
            }
            ;
            /**
             * 如果nums2数组已经到尾了就结束循环
             */
            if (bpointer == len2) {
                break;
            }
            /**
             * 如果nums1数组当前数和nums2数组当前数相等，则分别移动nums1数组和nums2数组的指针，并添加这个数
             */
            while (apointer < len1 && bpointer < len2 && nums1[apointer] == nums2[bpointer]) {
                result.add(nums1[apointer]);
                apointer++;
                bpointer++;
            }

            if (apointer == len1 || bpointer == len2) {
                break;
            }
            /**
             * 如果nums1当前的数比nums2当前的数小，那么说明nums1数组当前的数没有重复
             * 就跳过这些数，（前提是nums2数组角标没越界）
             */
            while (apointer < len1 && nums1[apointer] < nums2[bpointer]) {
                apointer++;
            }
            /**
             * 如果nums1数组已经到尾了，那么结束循环
             */
            if (apointer == len1) {
                break;
            }
        }
        int [] num = new int[result.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = result.get(i);
        }
        return num;
    }
}
