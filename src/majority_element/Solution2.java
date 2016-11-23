package majority_element;

import java.util.Map;
import java.util.TreeMap;

/**
 * 2016/11/23
 */

/**
 * hashtable solution
 */
public class Solution2 {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] num) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if (!map.containsKey(num[i])) {
                map.put(num[i], 1);
            } else {
                map.put(num[i], map.get(num[i]) + 1);
            }
            if (map.get(num[i]) > num.length / 2) {
                return num[i];
            }
        }
        return -1;
    }
}
