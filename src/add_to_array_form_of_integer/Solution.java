package add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.List;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        List<Integer> list = addToArrayForm(ArrayTestCaseTransformer.transform("[9,9,9,9,9,9,9,9,9,9]"), 1);
        System.out.println(list);

    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        int carry = K;
        for (int i = A.length - 1; i >= 0; i--) {
            A[i] += carry;
            carry = 0;
            if (A[i] >= 10) {
                carry = A[i] / 10;
                A[i] = A[i] % 10;
            }
        }
        List<Integer> list = new ArrayList<>(A.length + 1);
        while (carry > 0) {
            int d = carry % 10;
            list.add(0, d);
            carry /= 10;
        }
        for (int num : A) {
            list.add(num);
        }
        return list;
    }
}
