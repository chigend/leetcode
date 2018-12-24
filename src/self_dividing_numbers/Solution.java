package self_dividing_numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.selfDividingNumbers(1, 22);
        System.out.println(result);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        outer:for (int i = left; i <=  right; i++){
            int num = i;
            while (num != 0) {
                int digit = num % 10;
                num /= 10;
                if (digit == 0 || i % digit != 0) {
                    continue outer;
                }
            }
            result.add(i);
        }
        return result;
    }
}
