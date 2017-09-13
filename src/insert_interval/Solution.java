package insert_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Interval;

public class Solution {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(3, 5));
        System.out.println(insert(list, new Interval(6, 7)));
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        int start = -1;
        int end = -1;
        int left = -1;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (newInterval.start > cur.end) {
                result.add(cur);
            } else {
                start = Math.min(newInterval.start, cur.start);
                while (i < intervals.size() && newInterval.end > intervals.get(i).end) {
                    i++;
                }
                if (i == intervals.size()) {
                    result.add(new Interval(start, newInterval.end));
                }else if (newInterval.end < intervals.get(i).start) {
                    result.add(new Interval(start, newInterval.end));
                    result.add(intervals.get(i));
                } else {
                    result.add(new Interval(start, intervals.get(i).end));
                }
                left = ++i;
                break;
            }
        }
        for (int i = left; i < intervals.size(); i++) {
            result.add(intervals.get(i));
        }
        return result;
    }
}
