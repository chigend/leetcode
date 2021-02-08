package build_an_array_with_stack_operations;

import java.util.ArrayList;
import java.util.List;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        List<String> strings = buildArray(ArrayTestCaseTransformer.transform("[2,4]"), 4);
        System.out.println(strings);
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < target.length; ) {
            list.add("Push");
            if (target[i] != cur) {
                list.add("Pop");
            }else {
                i++;
            }
            cur++;
        }
        return list;
    }
}
