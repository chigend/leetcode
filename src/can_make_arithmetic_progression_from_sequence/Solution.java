package can_make_arithmetic_progression_from_sequence;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        for(int i = 1; i < arr.length - 1; i++) {
            if(2 * arr[i] != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;

    }
}
