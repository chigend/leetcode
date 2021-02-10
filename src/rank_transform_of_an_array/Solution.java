package rank_transform_of_an_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

    }

    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) {
            return arr;
        }
        int[] copy = new int[arr.length];
        for(int i = 0; i< arr.length; i++) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy);
        int order = 1;
        Map<Integer, Integer> orderMap = new HashMap<>();
        orderMap.put(copy[0], 1);
        for(int i = 1; i < copy.length; i++) {
            if(copy[i] > copy[i-1]) {
                order++;
            }
            orderMap.put(copy[i],order);
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = orderMap.get(arr[i]);
        }
        return arr;
    }
}

