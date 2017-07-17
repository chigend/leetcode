package exclusive_time_of_functions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-07-16-10:02
 */

public class Solution {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList("0:start:0",
        "0:start:2",
                "0:end:5",
                "0:end:6");
        int[] times = exclusiveTime(1,logs);
        System.out.println(Arrays.toString(times));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] strings = log.split(":");
            int id = Integer.parseInt(strings[0]);
            int unit = Integer.parseInt(strings[2]);
            if (strings[1].equals("start")) {

                if (!stack.isEmpty()) {
                    int preId = stack.peek();
                    time[preId] += unit - map.get(preId);
                }
                stack.push(id);
                map.put(id, unit);
            }else {
                int currentId = stack.pop();
                time[currentId] += unit - map.get(currentId) + 1;
                if (!stack.isEmpty()) {
                    map.put(stack.peek(), unit+1);
                }
            }
        }
        return time;
    }
}
