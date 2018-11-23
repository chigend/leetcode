package prime_number_of_set_bits_in_binary_representation;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int count = countPrimeSetBits(6,10);
        System.out.println(count);
    }

    public static int countPrimeSetBits(int L, int R) {
        int[] nums = {2,3,5,7,11,13,17,19,23,29,31};
        Set<Integer> primes = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int count = 0;
        for (int i = L; i <= R; i++) {
            count += primes.contains(countSetBits(i)) ? 1 : 0;
        }
        return count;
    }
    private static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
