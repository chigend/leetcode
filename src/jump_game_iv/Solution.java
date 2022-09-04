package jump_game_iv;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

    public int minJumps(int[] arr) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], new LinkedList<>());
            }
            map.get(arr[i]).add(i);
        }

        int[] distance = new int[n];
        int INF = (int) 1e9;
        Arrays.fill(distance, INF);
        distance[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer c = q.remove();
            for (int i = c - 1; i <= c + 1; i += 2) {
                if (i > 0 && i < n && distance[i] > distance[c] + 1) {
                    distance[i] = distance[c] + 1;
                    q.offer(i);
                }
            }
            int v = arr[c];
            if (map.get(v) != null) {
                for (int i : map.get(v)) {
                    if (i > 0 && i < n && distance[i] > distance[c] + 1) {
                        distance[i] = distance[c] + 1;
                        q.offer(i);
                    }
                }
                map.remove(v);
            }

        }

        return distance[n - 1];

    }
}
