package merge_intervals;

import java.util.*;

/**
 * @author yejinbiao
 * @create 2017-03-30-13:24
 */

public class Solution {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1,3));
        intervals = merge(intervals);
        System.out.print(intervals);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) return result;
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= end) {
                end = Math.max(interval.end,end);
            }else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start,end));
        return result;
    }
}
