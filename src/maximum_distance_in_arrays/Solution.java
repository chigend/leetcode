package maximum_distance_in_arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-06-19-13:04
 */

public class Solution {
    public static void main(String[] args) {
        List<Integer> list0 = Arrays.asList(-8, -7, -7, -5, 1, 1, 3, 4);
        List<Integer> list1 = Arrays.asList(-2);
        List<Integer> list2 = Arrays.asList(-10, -10, -7, 0, 1, 3);
        List<Integer> list3 = Arrays.asList(2);
        int max = maxDistance(Arrays.asList(list0, list1, list2, list3));
        System.out.println(max);

    }

    public static int maxDistance(List<List<Integer>> arrays) {

        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        int maxDistance = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            maxDistance = Math.max(maxDistance, Math.abs(list.get(0) - max));
            maxDistance = Math.max(maxDistance, Math.abs(list.get(list.size() - 1) - min));
            max = Math.max(list.get(list.size() - 1), max);
            min = Math.min(list.get(0), min);

        }
        return maxDistance;
    }
}
