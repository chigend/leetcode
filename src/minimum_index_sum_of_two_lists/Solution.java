package minimum_index_sum_of_two_lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-06-21-10:04
 */

public class Solution {
    public static void main(String[] args) {
        String[] str = {"Shogun", "Tapioca Express", "Burger King", "KFC","Piatti"};
        String[] str2 = {"Piatti", "The Grill at Torrey Pines", "Burger King", "Shogun"};
        str = findRestaurant(str, str2);
        System.out.println(Arrays.toString(str));
    }
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> indexes = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            indexes.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        Integer leastIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            Integer index = indexes.get(str);
            if (index != null) {
                int indexSum = index + i;
                if (indexSum < leastIndexSum) {
                    leastIndexSum = indexSum;
                    result.clear();
                }
                if (indexSum <= leastIndexSum) {
                    result.add(str);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
