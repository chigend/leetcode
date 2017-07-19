package exclusive_time_of_functions;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-07-16-10:02
 */

public class Solution {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList("0:start:0",
        "1:start:2",
                "1:end:5",
                "0:end:6");
        int[] times = exclusiveTime(2,logs);
        System.out.println(Arrays.toString(times));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<Integer> stack = new Stack<>();
        int preUnit = 0;
        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] strings = log.split(":");
            int id = Integer.parseInt(strings[0]);
            int unit = Integer.parseInt(strings[2]);
            if (strings[1].equals("start")) {
                if (!stack.isEmpty()) {
                    int preId = stack.peek();
                    time[preId] += unit - preUnit;
                }
                preUnit = unit;
                stack.push(id);
            }else {
                int currentId = stack.pop();
                time[currentId] += unit - preUnit + 1;
                if (!stack.isEmpty()) {
                    preUnit = unit + 1;
                }
            }
        }
        return time;
    }
}
