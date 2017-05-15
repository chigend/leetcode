package kill_process;

import model.ListNode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yejinbiao
 * @create 2017-05-15-9:38
 */

public class Solution {
    public static void main(String[] args) {
        List<Integer> pids = Arrays.asList(1,3,10,5);
        List<Integer>ppids = Arrays.asList(3,0,5,3);
        ppids = killProcess(pids,ppids,3);
        System.out.print(ppids);
    }

    public static List<Integer> killProcess(List<Integer> pids, List<Integer> ppids, int kill) {
        Map<Integer,List<Integer>> processes = new HashMap<>();
        for (int i = 0; i < ppids.size(); i++) {
            int ppid = ppids.get(i);
            List<Integer> childs = processes.get(ppid);
            if (childs == null) {
                childs = new ArrayList<>();
                processes.put(ppid,childs);
            }
            childs.add(pids.get(i));
            processes.put(ppid,childs);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(kill);
        while (!queue.isEmpty()) {
            int pid = queue.poll();
            result.add(pid);
            List<Integer> childs = processes.get(pid);
            if (childs != null) queue.addAll(processes.get(pid));

        }
        return result;
    }
}
