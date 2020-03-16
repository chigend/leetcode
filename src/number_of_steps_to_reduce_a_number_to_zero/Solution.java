package number_of_steps_to_reduce_a_number_to_zero;

public class Solution {
    public static void main(String[] args) {

    }

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num &= 0xfffffffe; // num -= 1;
            }
            count++;
        }
        return count;
    }
}
