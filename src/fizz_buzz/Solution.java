package fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-10-下午1:31
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <=n;i ++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                result.add("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                result.add("Buzz");
                continue;
            }
            result.add(i + "");
        }
        return  result;
    }
}
