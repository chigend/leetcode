package array_transformation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int[] transform = ArrayTestCaseTransformer.transform("[4,4,3,7]");
        List<Integer> list = transformArray(transform);
        System.out.println(list);
    }

    public static List<Integer> transformArray(int[] arr) {
        if (arr.length <= 2) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }

        boolean changed = true;

        while (changed) {
            changed = false;
            int[] adds = new int[arr.length];

            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    adds[i] = -1;
                    changed = true;
                }

                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    adds[i] = 1;
                    changed = true;
                }
            }
            for (int i = 0; i < adds.length; i++) {
                arr[i] += adds[i];
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}
