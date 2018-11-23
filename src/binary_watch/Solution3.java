package binary_watch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {

    }

    public List<String> readBinaryWatch(int num) {
        Map<Integer, List<String>> hourMap = new HashMap<>();
        Map<Integer, List<String>> minuteMap = new HashMap<>();
        for (int hour = 0; hour < 12; hour++) {
            int count = Integer.bitCount(hour);
            List<String> hourList = hourMap.getOrDefault(count, new ArrayList<>());
            hourList.add(""+hour);
            hourMap.put(count, hourList);
        }

        for (int minute = 0; minute < 60; minute++) {
            int count = Integer.bitCount(minute);
            List<String> minuteList = minuteMap.getOrDefault(count, new ArrayList<>());
            minuteList.add(minute < 10 ? "0" + minute : "" + minute);
            minuteMap.put(count, minuteList);
        }

        List<String> result = new ArrayList<>();

        for (int hourCount = 0; hourCount < 4 && hourCount <= num; hourCount++ ) {
            List<String> hourList = hourMap.get(hourCount);
            List<String> minuteList = minuteMap.getOrDefault(num - hourCount, new ArrayList<>());
            for (String hour : hourList ) {
                for (String minute : minuteList) {
                    result.add(hour + ":" + minute);
                }
            }
        }
        return result;
    }
}
