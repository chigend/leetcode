package combine_breakfast;

import java.util.Arrays;

import tool.ArrayTestCaseTransformer;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(breakfastNumber(ArrayTestCaseTransformer.transform("[10,20,5]"), ArrayTestCaseTransformer.transform("[5,5,2]"), 15));

    }

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        int count = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);

        for (int s : staple) {
            int i = binarySearch(drinks, x - s);
            if (i == 0) {
                break;
            }
            count = (count + i) % 1000000007;
        }
        return count % 1000000007;
    }

    public static int binarySearch(int[] array, int target) {
        int start = 0, end = array.length;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (array[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
