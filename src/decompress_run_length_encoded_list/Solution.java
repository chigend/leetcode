package decompress_run_length_encoded_list;

import tool.ArrayPrinter;
import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int[] transform = ArrayTestCaseTransformer.transform("[1,1,2,3]");
        int[] ints = decompressRLElist(transform);
        ArrayPrinter.print(ints);
    }

    public static int[] decompressRLElist(int[] nums) {
        int total = 0;
        for (int i = 1; i < nums.length; i += 2) {
            total += nums[i - 1];
        }
        int[] res = new int[total];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res[index++] = nums[i + 1];
            }
        }
        return res;
    }
}
