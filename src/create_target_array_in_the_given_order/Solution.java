package create_target_array_in_the_given_order;

import tool.ArrayPrinter;
import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int[] targetArray = createTargetArray(ArrayTestCaseTransformer.transform("[4,2,4,3,2]"), ArrayTestCaseTransformer.transform("[0,0,1,3,1]"));
        ArrayPrinter.print(targetArray);
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        for (int i = 0; i < index.length; i++) {
            int indice = index[i];
            for (int j = i + 1; j < index.length; j++) {
                if (index[j] <= indice) {
                    indice += 1;
                }
            }
            index[i] = indice;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[index[i]] = nums[i];
        }
        return res;
    }
}
