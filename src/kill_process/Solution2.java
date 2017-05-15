package kill_process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-05-15-12:57
 */

public class Solution2 {
    public static void main(String[] args) {
        List<Integer> pids = Arrays.asList(1,3,10,5);
        List<Integer>ppids = Arrays.asList(3,0,5,3);
        ppids = killProcess(pids,ppids,3);
        System.out.print(ppids);
    }

    public static List<Integer> killProcess(List<Integer> pids, List<Integer> ppid, int kill) {
        Map<Integer,List<Integer>> processes = new HashMap<>();
        //首先按照遍历父程序，并把其对应的子程序集合存储起来
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> list = processes.getOrDefault(ppid.get(i),new ArrayList<Integer>());
            list.add(pids.get(i));
            processes.put(ppid.get(i),list);
        }
        List<Integer> result = new ArrayList<>();
        kill(processes,kill,result);
        return result;

    }
    //然后深度优先去杀死程序，即杀死一个程序时，首先杀死其子程序
    private static void kill(Map<Integer,List<Integer>> processes,int kill,List<Integer>result) {
        result.add(kill);
        List<Integer> childs = processes.get(kill);
        if (childs == null) return ;
        for (Integer child : childs) {
            kill(processes, child, result);
        }
    }
}
