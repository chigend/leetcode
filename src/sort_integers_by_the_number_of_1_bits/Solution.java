package sort_integers_by_the_number_of_1_bits;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import sun.plugin.javascript.navig.Array;

public class Solution {

    public static void main(String[] args) {

    }

    public static int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            arr[i] %= 100000;
        }
        return arr;

    }
}
