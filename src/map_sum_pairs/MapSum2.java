package map_sum_pairs;

import java.util.HashMap;
import java.util.Map;

public class MapSum2 {
    private Map<String, Integer> map;
    public MapSum2() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }
    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        return sum;
    }
}