package find_right_interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import model.Interval;

/**
 * @author yejinbiao
 * @create 2017-06-25-9:23
 */

public class Solution {
    private static Map<Integer,Integer> hash;
    public static void main(String[] args) {
       Interval[] intervals =  { new Interval(1,4), new Interval(2,3), new Interval(3,4) };
       int[] result = findRightInterval(intervals);
       System.out.println(Arrays.toString(result));
    }

    public static int[] findRightInterval(Interval[] intervals) {
        /**
         * since the start in interval is distinct,so we store
         * start-original index into map
         */

        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hashMap.put(intervals[i].start,i);
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int[] indexes = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            /**
             *  then for each interval,we binary search the start which is the  closest
             *  to the current end.
             */

            Integer start = binarySearch(intervals,i+1,interval.end);
            /**
             * since we have stored the start-original index in map
             * so we just use the start to get the original index.
             */
            indexes[hashMap.get(interval.start)] = start == null ? -1 : hashMap.get(start);
        }
        return indexes;
    }

    private static Integer binarySearch(Interval[] intervals,int start,int target) {
        int low = start;
        int high = intervals.length-1;
        while (low <= high) {
            int med = (low + high) >> 1;
            int right = intervals[med].start;
            if (right >= target) {
                high = med - 1;
            }else {
                low = med+1;
            }
        }
        /**
         * if low equals to array length, it means the right interval does not exist
         * if we find ,we return the start of the interval
         */
        return low == intervals.length ? null : intervals[low].start;
    }
}
