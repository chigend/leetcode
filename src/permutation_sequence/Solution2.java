package permutation_sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-22-下午4:36
 */

public class Solution2 {
    public static void main(String[] args) {
        String permutation = getPermutation(4,24);
        System.out.print(permutation);
    }
    public static String getPermutation(int n, int k) {
        int [] factorials = {0,1,2,6,24,120,720,5040,40320,362880,3628800};
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);
        StringBuilder sb = new StringBuilder();
        k--;
        while (--n > 0) {
            int ways = factorials[n];
            int position = k / ways;
            int mod = k % ways;
            sb.append(numbers.remove(position));
            k = mod;
        }
        sb.append(numbers.get(0));
        return sb.toString();
    }
}
