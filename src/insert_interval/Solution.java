package insert_interval;

import java.util.ArrayList;
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
        for(int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (newInterval == null || newInterval.start > cur.end) {
                result.add(cur);
            }else if(newInterval.end < cur.start) {
                result.add(newInterval);
                result.add(cur);
                newInterval = null;
            }else{
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }
        }

        if (newInterval != null) {
            result.add(newInterval);
        }
        return result;
    }
}
